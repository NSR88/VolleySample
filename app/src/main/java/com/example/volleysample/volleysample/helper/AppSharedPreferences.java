package com.example.volleysample.volleysample.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;

import com.jivemap.app.R;
import com.jivemap.app.constants.AppGlobalConstants;


/**
 * Created by adisoft2 on 18/8/15.
 */
public class AppSharedPreferences {

    public static boolean loadIsSuccessfullyRegistered(Context ctx) {
        boolean isSuccessfullyRegistered = false;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            isSuccessfullyRegistered = prefs.getBoolean("successfullyRegistered", false);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isSuccessfullyRegistered;
    }

    public static void saveIsSuccessfullyRegisteredPreference(Context ctx, boolean isSuccessfullyRegistered) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
			editor.putBoolean("successfullyRegistered", isSuccessfullyRegistered);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public static boolean loadIsSelectedLocalChannel(Context ctx) {
        boolean isSelectedLocal = true;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            isSelectedLocal = prefs.getBoolean("isSelectedLocal", true);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isSelectedLocal;
    }

    public static void saveIsSelectedLocalChannelPreference(Context ctx, boolean isSelectedLocal) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
            editor.putBoolean("isSelectedLocal", isSelectedLocal);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static boolean loadIsAppStartedForTheFirstTimePreferences(Context ctx) {
        boolean IsAppStartedForTheFirstTime = true;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            IsAppStartedForTheFirstTime = prefs.getBoolean("IsAppStartedForTheFirstTime", true);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return IsAppStartedForTheFirstTime;
    }

    public static void saveIsAppStartedForTheFirstTimePreference(Context ctx, boolean IsAppStartedForTheFirstTime) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
            editor.putBoolean("IsAppStartedForTheFirstTime", IsAppStartedForTheFirstTime);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean loadIsUserLoggedIn(Context ctx) {
        boolean isUserLoggedIn = false;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            isUserLoggedIn = prefs.getBoolean("logged_in", false);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isUserLoggedIn;
    }

    public static void saveIsUserLoggedInPreference(Context ctx, boolean isUserLoggedIn) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
			editor.putBoolean("logged_in", isUserLoggedIn);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static boolean loadIsFBAuthenticated(Context ctx) {
        boolean isUserLoggedIn = false;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            isUserLoggedIn = prefs.getBoolean("FBAuthenticated", false);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isUserLoggedIn;
    }

    public static void saveFBAuthenticatedPreference(Context ctx, boolean isUserLoggedIn) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putBoolean("FBAuthenticated", isUserLoggedIn);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    public static void saveFBAuthAccessTokenPreference(Context ctx, String FBAuthAccessToken) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString("FBAuthAccessToken", FBAuthAccessToken);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveTwitterAuthAccessTokenPreference(Context ctx, String TwitterAuthAccessToken) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString("TwitterAuthAccessToken", TwitterAuthAccessToken);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean areNotificationsEnabledPreference(Context ctx) {
        boolean NotificationsEnabled = true;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            NotificationsEnabled = prefs.getBoolean("NotificationsEnabled", true);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NotificationsEnabled;
    }

    public static void saveNotificationsEnabledPreference(Context ctx, boolean NotificationsEnabled) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putBoolean("NotificationsEnabled", NotificationsEnabled);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


 public static int loadUnreadNotificationCount(Context ctx) {
        int unreadNotificationsCount = 0;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            unreadNotificationsCount = prefs.getInt("UnreadNotificationCount", 0);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return unreadNotificationsCount;
    }

    public static void saveUnreadNotificationsCount(Context ctx, int unreadNotificationsCount) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putInt("UnreadNotificationCount", unreadNotificationsCount);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 public static int loadUnreadMessagesCount(Context ctx) {
     int unreadMessagesCount = 0;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            unreadMessagesCount = prefs.getInt("UnreadMessagesCount", 0);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return unreadMessagesCount;
    }

    public static void saveUnreadMessagesCount(Context ctx, int unreadMessagesCount) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putInt("UnreadMessagesCount", unreadMessagesCount);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean loadIsTwitterAuthenticated(Context ctx) {
        boolean isUserLoggedIn = false;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            isUserLoggedIn = prefs.getBoolean("TwitterAuthenticated", false);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isUserLoggedIn;
    }

    public static void saveIsTwitterAuthenticatedPreference(Context ctx, boolean isUserLoggedIn) {
        try {
            // MY_PREFS_NAME - a static String variable like:
            //public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putBoolean("TwitterAuthenticated", isUserLoggedIn);

            editor.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveUserIDPreference(Context ctx, String userID) {

        try {

            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
            editor.putString("UserID", userID);
            editor.commit();
//			SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
//			UserIDStr = prefs.getString("UserID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String loadUserIDPreference(Context ctx) {
        String UserIDStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            UserIDStr = prefs.getString("UserID", AppGlobalConstants.DEFAULT_USER_ID);



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return UserIDStr;
    }
 public static void saveUserAccessTokenPreference(Context ctx, String UserAccessToken) {

        try {

            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString(ctx.getResources().getString(R.string.key_user_access_token), UserAccessToken);
            editor.commit();
//			SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
//			UserIDStr = prefs.getString("UserID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String loadUserAccessTokenPreference(Context ctx) {
        String UserAccessToken = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            UserAccessToken = prefs.getString(ctx.getResources().getString(R.string.key_user_access_token), "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return UserAccessToken;
    }
public static void saveSignupViaPreference(Context ctx, String signupVia) {

        try {

            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString(ctx.getResources().getString(R.string.key_signup_via), signupVia);
            editor.commit();
//			SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
//			UserIDStr = prefs.getString("UserID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String loadSignupViaPreference(Context ctx) {
        String signupVia = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            signupVia = prefs.getString(ctx.getResources().getString(R.string.key_signup_via), ctx.getResources().getString(R.string.value_normal));



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return signupVia;
    }

    public static void saveMyJiveIDToPreferences(Context ctx, String JiveID) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("JiveID", JiveID);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyJiveIDFromPreference(Context ctx) {
        String JiveIDStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            JiveIDStr = prefs.getString("JiveID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return JiveIDStr;
    }



    public static void saveMyNameToPreferences(Context ctx, String Name) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Name", Name);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyNameFromPreference(Context ctx) {
        String NameStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            NameStr = prefs.getString("Name", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NameStr;
    }
    public static void saveMyEmailToPreferences(Context ctx, String Email) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Email", Email);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyEmailFromPreference(Context ctx) {
        String EmailStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            EmailStr = prefs.getString("Email", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return EmailStr;
    }
    public static void saveMyNicknameToPreferences(Context ctx, String Nickname) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Nickname", Nickname);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyNicknameFromPreference(Context ctx) {
        String NicknameStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            NicknameStr = prefs.getString("Nickname", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return NicknameStr;
    }
    public static void saveMyCountryToPreferences(Context ctx, String Country) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Country", Country);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyCountryFromPreference(Context ctx) {
        String CountryStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            CountryStr = prefs.getString("Country", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return CountryStr;
    }
    public static void saveMyCityToPreferences(Context ctx, String City) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("City", City);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyCityFromPreference(Context ctx) {
        String CityStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            CityStr = prefs.getString("City", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return CityStr;
    }

    public static void saveMyWebsiteToPreferences(Context ctx, String WebsiteStr) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Website", WebsiteStr);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyWebsiteFromPreference(Context ctx) {
        String DescriptionStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            DescriptionStr = prefs.getString("Website", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return DescriptionStr;
    }

    public static void saveMyDescriptionToPreferences(Context ctx, String DescriptionStr) {
        try {
			// MY_PREFS_NAME - a static String variable like:
			//public static final String MY_PREFS_NAME = "MyPrefsFile";
			SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
			editor.putString("Description", DescriptionStr);

			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static String loadMyDescriptionFromPreference(Context ctx) {
        String DescriptionStr = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            DescriptionStr = prefs.getString("Description", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return DescriptionStr;
    }


 public static void saveProfilePicURLPreference(Context ctx, String ProfilePicURL) {

        try {

            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString("ProfilePicURL", ProfilePicURL);
            editor.commit();
//			SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
//			UserIDStr = prefs.getString("UserID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String loadProfilePicURLPreference(Context ctx) {
        String ProfilePicURL = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref" + loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            ProfilePicURL = prefs.getString("ProfilePicURL", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ProfilePicURL;
    }
 public static void saveCoverPicURLPreference(Context ctx, String CoverPicURL) {

        try {

            SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE).edit();
            editor.putString("CoverPicURL", CoverPicURL);
            editor.commit();
//			SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
//			UserIDStr = prefs.getString("UserID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public static String loadCoverPicURLPreference(Context ctx) {
        String CoverPicURL = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref"+loadUserIDPreference(ctx), Context.MODE_PRIVATE);
            CoverPicURL = prefs.getString("CoverPicURL", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return CoverPicURL;
    }

    public static String loadGCMDeviceIDPreference(Context ctx) {
        String GCM_ID = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            GCM_ID = prefs.getString("GCM_ID", "");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return GCM_ID;
    }

    public static void saveGCMDeviceIDPreference(Context ctx, String GCM_ID) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putString("GCM_ID", GCM_ID);

        editor.commit();
    }





 public static double loadLatestSavedLatitudePreference(Context ctx) {
        double latitude = 0.0;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            latitude = Double.longBitsToDouble(prefs.getLong("latitude", 0));



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return latitude;
    }

    public static void saveLatestSavedLatitudePreference(Context ctx, double latitude) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putLong("latitude", Double.doubleToRawLongBits(latitude));

        editor.commit();
    }

public static double loadLatestSavedLongitudePreference(Context ctx) {
        double longitude = 0.0;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            longitude = Double.longBitsToDouble(prefs.getLong("longitude", 0));



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return longitude;
    }

    public static void saveLatestSavedLongitudePreference(Context ctx, double longitude) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putLong("longitude", Double.doubleToRawLongBits(longitude));

        editor.commit();
    }


public static long loadLatestSavedLocationTimeInMillisPreference(Context ctx) {
        long loc_time_in_millis = 0;
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            loc_time_in_millis = prefs.getLong("loc_time_in_millis", 0);



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return loc_time_in_millis;
    }

    public static void saveLatestSavedLocationTimeInMillisPreference(Context ctx, long loc_time_in_millis) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putLong("loc_time_in_millis", loc_time_in_millis);

        editor.commit();
    }


    public static String loadLastSavedLocationProviderPreference(Context ctx) {
        String loc_provider = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            loc_provider = prefs.getString("loc_provider", LocationManager.NETWORK_PROVIDER);



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return loc_provider;
    }

    public static void saveLastSavedLocationProviderPreference(Context ctx, String loc_provider) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putString("loc_provider", loc_provider);

        editor.commit();
    }




   public static String loadGeoAccuracyPreference(Context ctx) {
        String GeoAccuracy = "";
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
            GeoAccuracy = prefs.getString("GeoAccuracy", "0");



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return GeoAccuracy;
    }

    public static void saveGeoAccuracyPreference(Context ctx, String GeoAccuracy) {
        // MY_PREFS_NAME - a static String variable like:
        //public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = ctx.getSharedPreferences("AppPref", Context.MODE_PRIVATE).edit();
        editor.putString("GeoAccuracy", GeoAccuracy);

        editor.commit();
    }



}
