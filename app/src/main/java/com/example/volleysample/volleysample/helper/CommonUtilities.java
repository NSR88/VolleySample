package com.example.volleysample.volleysample.helper;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.jivemap.app.R;
import com.jivemap.app.constants.AppGlobalConstants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.entity.BufferedHttpEntity;
//import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by adisoft2 on 17/8/15.
 */
public class CommonUtilities {

    private static final String class_name = "CommonUtilities";


    public static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setupUI(View view, final Activity activity) {

        try {
            //Set up touch listener for non-text box views to hide keyboard.
            if (!(view instanceof EditText)) {

                view.setOnTouchListener(new View.OnTouchListener() {

                    public boolean onTouch(View v, MotionEvent event) {
                        hideSoftKeyboard(activity);
                        return false;
                    }

                });
            }

            //If a layout container, iterate over children and seed recursion.
            if (view instanceof ViewGroup) {

                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                    View innerView = ((ViewGroup) view).getChildAt(i);

                    setupUI(innerView, activity);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String getSpaceSeparatedValuesFromArrayList(ArrayList<String> objectArrayList) {
        String output = "";
        output = objectArrayList.toString().replace("[", "").replace("]", "")
                .replace(", ", " ").trim();
        return output;
    }

    public static String getSpaceSeparatedMentionValuesWith_atTheRateFromArrayList(ArrayList<String> objectArrayList) {

        for(int i=0; i<objectArrayList.size(); i++) {
            objectArrayList.set(i,"@"+objectArrayList.get(i));
        }


        String output = "";
        output = objectArrayList.toString().replace("[", "").replace("]", "")
                .replace(", ", " ").trim();
        return output;
    }


    public static boolean isFacebookAppInstalled(Context ctx) {

        return isSpcifiedPackageInstalled(ctx, com.jivemap.app.constants.AppGlobalConstants.FACEBOOK_PKG_NAME);
    }


    public static boolean isTwitterAppInstalled(Context ctx) {
        return isSpcifiedPackageInstalled(ctx, com.jivemap.app.constants.AppGlobalConstants.TWITTER_PKG_NAME);
    }
    public static boolean isSpcifiedPackageInstalled(Context ctx, String package_name) {
        List<ApplicationInfo> packages;
        PackageManager pm;

        pm = ctx.getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(package_name))
                return true;
        }
        return false;
    }

    public static boolean isValidURL(String urlStr) {
//        boolean isValid = true;
//        try { URL url = new URL(urlStr); }
//        catch (MalformedURLException e) {
//            isValid = false;
//         /* invalid URL */ }
//        return isValid;


//        UrlValidator vl;
        Pattern p = Patterns.WEB_URL;
        Matcher m = p.matcher(urlStr);
        if(m.matches())
            return true;
        else
            return false;
    }

    public static Bitmap getCorrectBitmap(Bitmap bitmap, String filePath) {
        ExifInterface ei;
        Bitmap rotatedBitmap = bitmap;
        try {
            ei = new ExifInterface(filePath);

            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            Matrix matrix = new Matrix();
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    matrix.postRotate(90);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    matrix.postRotate(180);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    matrix.postRotate(270);
                    break;
            }

            rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rotatedBitmap;
    }


    public static boolean doesJiveListContainJiveWithId(List<com.jivemap.app.Models.TrendingJivesModel> list, String jiveId) {
        for (com.jivemap.app.Models.TrendingJivesModel mModel : list) {
            if (mModel.getjiveID().equalsIgnoreCase(jiveId)) {
                return true;
            }
        }
        return false;
    }
    public static boolean doesNotificationListContainNotificationWithId(List<com.jivemap.app.Models.NotificationsModel> list, String NoteId) {
        for (com.jivemap.app.Models.NotificationsModel mModel : list) {
            if (mModel.getNoteID().equalsIgnoreCase(NoteId)) {
                return true;
            }
        }
        return false;
    }

    public static Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public static boolean isImageFileSizeGreaterThanDesired(File f) {
        long size = 0;
        size=f.length()/1024;



        return size> com.jivemap.app.constants.AppGlobalConstants.IMAGE_TO_UPLOAD_MAX_FILE_SIZE_IN_KB;
    }

    public static Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        if(width > height) {
            if(width > 500)
                maxSize = width * 75 / 100;
        } else {
            if(height > 500)
                maxSize = height * 75 / 100;
        }



        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        Bitmap reduced_bitmap = Bitmap.createScaledBitmap(image, width, height, true);
//        Log.d("file_size","file_size_during_manipulation: "+String.valueOf(sizeOf(reduced_bitmap)));
        if(sizeOf(reduced_bitmap) > (500 * 1000)) {
            return getResizedBitmap(reduced_bitmap, maxSize);
        } else {
            return reduced_bitmap;
        }
    }
    public static File copyInputStreamToFile( InputStream input, File file ) {
        try {
//            File file = new File(getCacheDir(), "cacheFileAppeal.srl");
            OutputStream output = new FileOutputStream(file);
            try {
                try {
                    byte[] buffer = new byte[4 * 1024]; // or other buffer size
                    int read;

                    while ((read = input.read(buffer)) != -1) {
                        output.write(buffer, 0, read);
                    }
                    output.flush();
                } finally {
                    output.close();
                }

            } catch (Exception e) {
                e.printStackTrace(); // handle exception, define IOException and others
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static Bitmap getResizedBitmap(Bitmap image, int maxSize, long file_size_in_bytes) {
        int width = image.getWidth();
        int height = image.getHeight();

        if(maxSize == 500) {
        if (file_size_in_bytes <= AppGlobalConstants.CAMERA_IMAGE_MAX_DESIRED_SIZE_IN_BYTES) {
            if (width > height) {
                if (width > 500)
                    maxSize = width * 75 / 100;
            } else {
                if (height > 500)
                    maxSize = height * 75 / 100;
            }
        } else if (file_size_in_bytes <= 5000000) {
            if (width > height) {
                if (width > 500)
                    maxSize = width * 30 / 100;
            } else {
                if (height > 500)
                    maxSize = height * 30 / 100;
            }


//
        } else {

            if (width > height) {
                if (width > 500)
                    maxSize = width * 13 / 100;
            } else {
                if (height > 500)
                    maxSize = height * 13 / 100;
            }

        }
    }

        if(maxSize > 800) {
            maxSize = 800;
        }

        if(maxSize > 600) {
            maxSize = maxSize * 90 / 100;
        }


        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        Bitmap reduced_bitmap = Bitmap.createScaledBitmap(image, width, height, true);
        if (image!= reduced_bitmap){
            image.recycle();
        }
//        Log.d("file_size","file_size_during_manipulation: "+String.valueOf(sizeOf(reduced_bitmap)));
        if(sizeOf(reduced_bitmap) > (AppGlobalConstants.IMAGE_TO_UPLOAD_MAX_FILE_SIZE_IN_KB * 1000)) {
            return getResizedBitmap(reduced_bitmap, maxSize, sizeOf(reduced_bitmap));
        } else {
            return reduced_bitmap;
        }
    }

    public static Bitmap getResizedBitmapForTesting(Bitmap image, int maxSize, long file_size_in_bytes) {
        int width = image.getWidth();
        int height = image.getHeight();


        if(file_size_in_bytes <= AppGlobalConstants.TEST_CAMERA_IMAGE_MAX_DESIRED_SIZE_IN_BYTES) {
            if (width > height) {
                if (width > 500)
                    maxSize = width * 75 / 100;
            } else {
                if (height > 500)
                    maxSize = height * 75 / 100;
            }
        } else {
        }

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        Bitmap reduced_bitmap = Bitmap.createScaledBitmap(image, width, height, true);
        if (image!= reduced_bitmap){
            image.recycle();
        }
//        Log.d("file_size","file_size_during_manipulation: "+String.valueOf(sizeOf(reduced_bitmap)));
        if(sizeOf(reduced_bitmap) > (AppGlobalConstants.IMAGE_TO_UPLOAD_MAX_FILE_SIZE_IN_KB * 1000)) {
            return getResizedBitmapForTesting(reduced_bitmap, maxSize, sizeOf(reduced_bitmap));
        } else {
            return reduced_bitmap;
        }
    }



    public static Bitmap getResizedBitmapForGallery(Bitmap image, int maxSize) {


        int width = image.getWidth();
        int height = image.getHeight();

//        maxSize += 300;

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }


        Bitmap reduced_bitmap = Bitmap.createScaledBitmap(image, width, height, true);
        if(sizeOf(reduced_bitmap) > (500 * 1000)) {
            return getResizedBitmapForGallery(reduced_bitmap, maxSize);
        } else {
            return reduced_bitmap;
        }



    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static long sizeOf(Bitmap data) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        data.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] imageInByte = stream.toByteArray();
        long lengthbmp = imageInByte.length;
        return lengthbmp;
    }




    public static String encodeURLSpecialCharacters(String param) {



        StringBuilder builder = new StringBuilder(param.length());

        for (int i = 0; i < param.length(); i++) {
            char c = param.charAt(i);
            switch (c) {
                case '*':
                    builder.append("%2A");
                    break;
                case '!':
                    builder.append("%21");
                    break;
                case '(':
                    builder.append("%28");
                    break;
                case ')':
                    builder.append("%29");
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();

//        return param;

    }


    public static String replaceSpecial(String input) {
        // Output will be at least as long as input
        StringBuilder builder = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '*':
                    builder.append("%2A");
                    break;
                case '!':
                    builder.append("%21");
                    break;
                case '(':
                    builder.append("%28");
                    break;
                case ')':
                    builder.append("%29");
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();
    }

    public static String getRealPathFromURI(Context ctx, Uri uri) {
        Cursor cursor = ctx.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm =
                (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void writeUserIDToFile(Context ctx, String user_id) {
        try {
            String extr = Environment.getExternalStorageDirectory().toString();
            File mFolder = new File(extr + "/Jive");
            if (!mFolder.exists()) {
                mFolder.mkdirs();
            }
            File myFile = new File(mFolder.getAbsolutePath() + "/user_id.txt");
            if (!myFile.exists() || !myFile.isFile()) {
                myFile.createNewFile();
            } else {
                FileWriter fw;
                try {
                    fw = new FileWriter(myFile);
                    fw.write("");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(user_id);
            myOutWriter.close();
            fOut.close();
//            Toast.makeText(ctx,
//                    "Done writing SD 'mysdfile.txt'",
//                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
//            Toast.makeText(ctx, e.getMessage(),
//                    Toast.LENGTH_SHORT).show();
        }
    }

    public static File getCacheDir(Context ctx) {
        File cacheDir = new File("");
        try {
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED))
                cacheDir = new File(
                        Environment.getExternalStorageDirectory(),
                        "/Android/data/" + ctx.getPackageName() + "/files/");
            else
                cacheDir = ctx.getCacheDir();
            if (!cacheDir.exists())
                cacheDir.mkdirs();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            com.jivemap.app.helper.Logs.setLogException("CommonUtilities", "getCacheDir", e);
        }

        return cacheDir;
    }

    public static File createAppFolderInSDCardInNotExists() {
        File mFolder = null;
        try {
            String extr = Environment.getExternalStorageDirectory().toString();
            mFolder = new File(extr + "/Jive");
            if (!mFolder.exists()) {
                mFolder.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mFolder;
    }


    public static String copyFromURLToFilePath(Context ctx, String urlString, String filepath, String newFileName) {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(false);
            urlConnection.connect();
            File SDCardRoot = Environment.getExternalStorageDirectory().getAbsoluteFile();
            String filename=newFileName;
            Log.i("Local filename:", "" + filename);
            File file = new File(SDCardRoot,filename);
            if(file.createNewFile())
            {
                file.createNewFile();
            }
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            int totalSize = urlConnection.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ( (bufferLength = inputStream.read(buffer)) > 0 )
            {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
                Log.i("Progress:","downloadedSize:"+downloadedSize+"totalSize:"+ totalSize) ;
            }
            fileOutput.close();
            if(downloadedSize==totalSize) filepath=file.getPath();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            filepath=null;
            e.printStackTrace();
        }
        Log.i("filepath:"," "+filepath) ;
        return filepath;
    }



    public static String copyFacebookProfilePicFromURLToFilePath(String fbUserID, Context ctx, String urlString, String filepath, String newFileName) {
        try
        {

            URL imageURL = new URL("https://graph.facebook.com/" + fbUserID + "/picture?type=large");
            Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

            File SDCardRoot = Environment.getExternalStorageDirectory().getAbsoluteFile();
            String filename=newFileName;
            Log.i("Local filename:", "" + filename);
            File file = new File(SDCardRoot,filename);
            if(file.createNewFile())
            {
                file.createNewFile();
            }
//Convert bitmap to byte array
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

//write the bytes in file
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(bytes.toByteArray());
//
            filepath=file.getPath();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            filepath=null;
            e.printStackTrace();
        }
        Log.i("filepath:"," "+filepath) ;
        return filepath;
    }






    public static ArrayList<String> getCountryList() {
        ArrayList<String> list = new ArrayList<String>();

        try {
            String[] locales = Locale.getISOCountries();

            for (String countryCode : locales) {

                Locale obj = new Locale("", countryCode);

                System.out.println("Country Name = " + obj.getDisplayCountry());
                list.add(obj.getDisplayCountry());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static boolean containsSpecialCharacters(String str) {
        boolean containsSpecialCharacters = false;


        try {
            String INPUT = "[ .a-zA-Z0-9_-]+";
            Pattern PATTERN = Pattern.compile(INPUT);
            Matcher matcher = PATTERN.matcher(str);


            if (matcher.matches()) {
                //login here
                containsSpecialCharacters = false;
            } else {
                //do something else
                containsSpecialCharacters = true;
            }
        } catch (Exception e) {
            com.jivemap.app.helper.Logs.setLogException(class_name, "parseJsonUpdateProfile", e);
        }
        return containsSpecialCharacters;
    }

    public static String getSHA256(String baseString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(baseString.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getUserDefinedDeviceID(Context ctx) {
        String deviceName = "";

        try {
            BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
            deviceName = myDevice.getName();
        } catch (Exception e) {
            com.jivemap.app.helper.Logs.setLogException(class_name, "getUserDefinedDeviceID()", e);
        }

        return deviceName;
    }

    public static ArrayList<com.jivemap.app.CustomizedViews.Item> getUtilitySliderItems(Context ctx, String menu_category) {

        ArrayList<com.jivemap.app.CustomizedViews.Item> items = new ArrayList<com.jivemap.app.CustomizedViews.Item>();
        try {
            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_trending_jives)));

            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_jivemap)));
            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_channels)));
            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_local)));
            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_everywhere)));


            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_myfollowing)));


//            ArrayList<String> followingChannelsNameList = com.jivemap.app.helper.DataHelper.getInstance(ctx).getfollowingChannelsNameList(com.jivemap.app.helper.AppSharedPreferences.loadUserIDPreference(ctx));
//
//            Collections.sort(followingChannelsNameList, String.CASE_INSENSITIVE_ORDER);
//
//            for(int count = 0; count < followingChannelsNameList.size(); count++) {
//                if(followingChannelsNameList.get(count).contains(menu_category) || menu_category.equalsIgnoreCase("")) {
//                    items.add(new com.jivemap.app.CustomizedViews.EntryItem("#" + followingChannelsNameList.get(count)));
//                }
//            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return items;

    }
 public static ArrayList<com.jivemap.app.CustomizedViews.Item> getUtilitySliderItemsForChannels(Context ctx, String menu_category) {

        ArrayList<com.jivemap.app.CustomizedViews.Item> items = new ArrayList<com.jivemap.app.CustomizedViews.Item>();
        try {
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_trending_jives)));
//
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_jivemap)));
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_channels)));
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_local)));
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_item_everywhere)));
//
//
//            items.add(new com.jivemap.app.CustomizedViews.EntryItem(ctx.getResources().getString(R.string.menu_section_myfollowing)));


            ArrayList<String> followingChannelsNameList = com.jivemap.app.helper.DataHelper.getInstance(ctx).getfollowingChannelsNameList(com.jivemap.app.helper.AppSharedPreferences.loadUserIDPreference(ctx));

            Collections.sort(followingChannelsNameList, String.CASE_INSENSITIVE_ORDER);

            for(int count = 0; count < followingChannelsNameList.size(); count++) {
                if(followingChannelsNameList.get(count).toLowerCase().contains(menu_category.toLowerCase()) || menu_category.equalsIgnoreCase("")) {
                    items.add(new com.jivemap.app.CustomizedViews.EntryItem("#" + followingChannelsNameList.get(count)));
                }
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return items;

    }

    public static String getLatestLatitude(Context ctx, String provider) {
        String lat = "0.0";
        ctx = App.getContext();
        try {
//            GPSTracker gpsTracker = GPSTracker.getInstance(ctx, provider);
//            lat = String.valueOf(gpsTracker.latitude);
            lat = String.valueOf(com.jivemap.app.helper.AppSharedPreferences.loadLatestSavedLatitudePreference(ctx));

            if(lat.equalsIgnoreCase("0.0") && (getLatestLocationUsingCriteria(ctx) != null)) {
                lat = String.valueOf(getLatestLocationUsingCriteria(ctx).getLatitude());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lat;
    }

    public static String getLatestLongitude(Context ctx, String provider) {
        String lon = "0.0";
        ctx = App.getContext();
        try {
//            GPSTracker gpsTracker = GPSTracker.getInstance(ctx, provider);
//            lon = String.valueOf(gpsTracker.longitude);
            lon = String.valueOf(com.jivemap.app.helper.AppSharedPreferences.loadLatestSavedLongitudePreference(ctx));

            if(lon.equalsIgnoreCase("0.0")&& (getLatestLocationUsingCriteria(ctx) != null)) {
                lon = String.valueOf(getLatestLocationUsingCriteria(ctx).getLongitude());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lon;
    }
    public static Location getLatestLocation(Context ctx, String provider) {
        Location loc = null;

        try {
//            com.jivemap.app.services.GPSTracker gpsTracker = com.jivemap.app.services.GPSTracker.getInstance(ctx, provider);
//            loc = gpsTracker.location;

            ctx = App.getContext();

            double lat = AppSharedPreferences.loadLatestSavedLatitudePreference(ctx);
            double lon = AppSharedPreferences.loadLatestSavedLongitudePreference(ctx);

            if(lat != 0.0 || lon != 0.0) {
                loc = new Location(provider);
                loc.setLatitude(lat);
                loc.setLongitude(lon);
            } else {
                loc = getLatestLocationUsingCriteria(App.getContext());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loc;
    }

    public static Location getLatestLocationUsingCriteria(Context ctx) {
        Location location = null;
        double latitude = 0.0;
        double longitude = 0.0;
        try {
            LocationManager locationManager = (LocationManager) ctx
                    .getSystemService(Context.LOCATION_SERVICE);
            Criteria crit = new Criteria();
            crit.setAccuracy(Criteria.ACCURACY_COARSE);
            String provider = LocationManager.PASSIVE_PROVIDER;
            if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                location = locationManager.getLastKnownLocation(provider);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    public static String getConvertedDateTimeFormat(String received_format, String display_format, String datetime) {
        String toDisplayDateTime = datetime;
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                received_format);
        Date myDate = null;
        try {
            myDate = dateFormat.parse(datetime);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat(display_format);
        toDisplayDateTime = timeFormat.format(myDate);
        return toDisplayDateTime;
    }

    public static String getTimeZone() {
        String timeZoneString = "GMT";
//        try {
//            TimeZone tz = TimeZone.getDefault();
//            timeZoneString = tz.getDisplayName(false, TimeZone.SHORT);
//            System.out.println("TimeZone   "+tz.getDisplayName(false, TimeZone.SHORT)+" Timezon id :: " +tz.getID());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return timeZoneString;
    }
    public static String getUTCOffset() {
        String timeZoneString = "GMT";
        try {
            TimeZone tz = TimeZone.getDefault();
            timeZoneString = tz.getDisplayName(false, TimeZone.SHORT).replaceAll("GMT","");
            System.out.println("TimeZone   "+tz.getDisplayName(false, TimeZone.SHORT)+" Timezon id :: " +tz.getID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeZoneString;
    }
    public static String getTimeAgoStringByDate(String dateTimeReceivedInGMT) {
        String timeAgoStr = getConvertedDateTimeFormat(com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT, com.jivemap.app.constants.AppGlobalConstants.TO_DISPLAY_TIME_FORMAT, dateTimeReceivedInGMT);
        try {


            SimpleDateFormat inputFormat = new SimpleDateFormat(
                    com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT, Locale.getDefault());
            inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

            SimpleDateFormat outputFormat = new SimpleDateFormat(com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT);
// Adjust locale and zone appropriately

            Date date = inputFormat.parse(dateTimeReceivedInGMT);
            String dateTimeReceivedInLocal = outputFormat.format(date);



            SimpleDateFormat format = new SimpleDateFormat(com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT);
            Date past = format.parse(dateTimeReceivedInLocal);
            Date now = new Date();


            Calendar startCalendar = new GregorianCalendar();
            startCalendar.setTime(past);
            Calendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(now);

            int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            long difference_in_months  = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

            long difference_in_days = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());
            long difference_in_hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long difference_in_mins = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long difference_in_secs = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());

            if (difference_in_months > 0) {
                timeAgoStr = difference_in_months + ((difference_in_months > 1) ? " months ago" : " month ago");
            } else if (difference_in_days > 0) {
                timeAgoStr = difference_in_days + ((difference_in_days > 1) ? " days ago" : " day ago");
            } else if (difference_in_hours > 0) {
                timeAgoStr = difference_in_hours + ((difference_in_hours > 1) ? " hours ago" : " hour ago");
            } else if (difference_in_mins > 0) {
                timeAgoStr = difference_in_mins + ((difference_in_mins > 1) ? " mins ago" : " min ago");
            } else if (difference_in_secs > 0) {
                timeAgoStr = difference_in_secs + ((difference_in_secs > 1) ? " seconds ago" : " second ago");
            } else {
                timeAgoStr = "Just now";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timeAgoStr;
    }
    public static String getConvertedLocalTime24hourFormatByGMTDateTimeString(String dateTimeReceivedInGMT) {
        String converted_time = dateTimeReceivedInGMT;
        try {
//            converted_time = getConvertedDateTimeFormat(AppGlobalConstants.SERVER_DATETIME_FORMAT, AppGlobalConstants.TO_DISPLAY_TIME_FORMAT, dateTimeReceivedInGMT);

            SimpleDateFormat inputFormat = new SimpleDateFormat(
                    com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT, Locale.getDefault());
            inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

            SimpleDateFormat outputFormat = new SimpleDateFormat(com.jivemap.app.constants.AppGlobalConstants.TO_DISPLAY_TIME_FORMAT);
// Adjust locale and zone appropriately

            Date date = inputFormat.parse(dateTimeReceivedInGMT);
            converted_time = outputFormat.format(date);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return converted_time;
    }
    public static String getConvertedGMTDateTimeStringFromLocalDateTime() {
        String converted_time = new Date().toString();
        try {
//            converted_time = getConvertedDateTimeFormat(AppGlobalConstants.SERVER_DATETIME_FORMAT, AppGlobalConstants.TO_DISPLAY_TIME_FORMAT, dateTimeReceivedInGMT);
            //Date will return local time in Java
            Date localTime = new Date();

            //creating DateFormat for converting time from local timezone to GMT
            DateFormat converter = new SimpleDateFormat(com.jivemap.app.constants.AppGlobalConstants.SERVER_DATETIME_FORMAT);

            //getting GMT timezone, you can get any timezone e.g. UTC
            converter.setTimeZone(TimeZone.getTimeZone("GMT"));

            converted_time = converter.format(localTime);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return converted_time;
    }
    public static boolean isServiceRunning(Context ctx, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    public static boolean isFacebookLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    public static boolean containsCaseInsensitive(String strToCompare, ArrayList<String>list)
    {
        for(String str:list)
        {
            if(str.equalsIgnoreCase(strToCompare))
            {
                return(true);
            }
        }
        return(false);
    }

}
