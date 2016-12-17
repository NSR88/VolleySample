package com.example.volleysample.volleysample.constants;

public class AppGlobalConstants {
	

	
	
	/* webrequests   */

//    public static final String WEBSERVICE_BASE_URL_FULL_FOR_UPLOADING_MEDIA = "https://shsh.com/api/upload_media.php";    // uncomment when publish
    public static final String WEBSERVICE_BASE_URL_FULL_FOR_UPLOADING_MEDIA = "https://shsh.com/dev/upload_media.php";   // comment it when release / publish

    //    public static final String SCHEME = "http";
//    public static final String PREFIX_PATH = "/v1.1/";
    public static final String SCHEME = "https";

    public static final String WEBSERVICE_BASE_URL = "yoyomap.com";
//        public static final String PREFIX_PATH = "/api/";                  // uncomment when publish
    public static final String PREFIX_PATH = "/dev/";                       // comment it when release / publish
    public static final String WEBSERVICE_BASE_URL_FULL ="https://yoyomap.com/dev";
    public static final String WEBSERVICE_CREATE_USER = "create_user.php";
    public static final String WEBSERVICE_USER_AUTH = "user_auth.php";
    public static final String WEBSERVICE_UPDATE_USER = "update_user.php";
    public static final String WEBSERVICE_VERIFY_EMAIL = "verify_email.php";
    public static final String WEBSERVICE_UPDATE_USER_SN = "update_user_sn.php";
    public static final String WEBSERVICE_UPDATE_yoyo = "update_yoyo.php";
    public static final String WEBSERVICE_UPLOAD_MEDIA = "upload_media.php";
    public static final String WEBSERVICE_GET_yoyoS = "get_yoyos.php";
    public static final String WEBSERVICE_GET_CHANNEL_FEEDS = "get_channel_feeds.php";
    public static final String WEBSERVICE_ACTION_ON_yoyo = "action_on_yoyo.php";
    public static final String WEBSERVICE_ACTION_ON_CHANNEL = "action_on_channel.php";
    public static final String WEBSERVICE_ACTION_ON_USER = "action_on_user.php";
    public static final String WEBSERVICE_POST_yoyo = "post_yoyo.php";
    public static final String WEBSERVICE_EDIT_yoyo = "update_yoyo.php";
    public static final String WEBSERVICE_SUGGEST_CHANNELS = "_suggest_channels.php";
    public static final String WEBSERVICE_GET_USERS = "get_users.php";
    public static final String WEBSERVICE_GET_USER_SN = "get_user_sn.php";
    public static final String WEBSERVICE_GET_FAVS = "get_favs.php";
    public static final String WEBSERVICE_SEARCH = "search.php";
    public static final String WEBSERVICE_GET_NOTIFICATIONS = "get_notifications.php";
    public static final String WEBSERVICE_READ_NOTIFICATIONS = "read_notification.php";
    public static final String WEBSERVICE_APP_AUTH = "app_auth.php";
    public static final String WEBSERVICE_GET_MSG_USERS = "get_msg_users.php";
    public static final String WEBSERVICE_GET_MSGS = "get_msgs.php";
    public static final String WEBSERVICE_READ_MSG = "read_msg.php";
    public static final String WEBSERVICE_SEND_MSG = "send_msg.php";
    public static final String WEBSERVICE_CHECK_FRIEND = "check_friend.php";


//    URL constants

    public static final String URL_FORGOT_PASSWORD = "https://www.yoyomap.com/reset_password.php";

//    key value constants

    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_yoyoMAP_OPENED_FOR_THE_FIRST_TIME = "yoyomap_opened_for_the_first_time";
    public static final String KEY_yoyo_REPLY_OR_ORIGINAL = "yoyoReplyOrOriginal";
    public static final String KEY_IS_yoyo_EDIT_MODE = "isyoyoEditMode";
    public static final String VALUE_REyoyo = "reyoyo";
    public static final String VALUE_REPLY = "reply";
    public static final String VALUE_ORIGINAL = "original";
    public static final String VALUE_EDIT = "edit";
    public static final String KEY_SEARCHINPUT = "search_input";
    public static final String KEY_SEARCHCATEGORY = "search_category";
    public static final String VALUE_SEARCHCATEGORY_CHANNELS = "search_category_channel";
    public static final String VALUE_SEARCHCATEGORY_TOPICS = "search_category_topic";
    public static final String KEY_FROM_INSIDE_CHANNEL = "from_inside_channel";
    public static final String KEY_FROM_PEOPLE_SCREEN = "from_people_screen";
    public static final String KEY_FROM_yoyoDETAILS_SCREEN = "from_yoyodetails_screen";
    public static final String KEY_CHANNEL_NAME = "channel_name";
    public static final String KEY_FROM_SCREEN = "from_screen";
    public static final String VALUE_TRENDING_yoyoS_SCREEN = "trending_yoyos_screen";
    public static final String VALUE_CHANNELS_SCREEN = "channels_screen";
    public static final String VALUE_PEOPLE_SCREEN = "people_screen";
    public static final String KEY_IS_SELECTED_LOCAL = "isSelectedLocal";
    public static final String KEY_SHOULD_NOT_SHOW_SWITCHING_LOADER = "should_not_show_switching";
    public static final String KEY_MSG_USER_MODEL = "msgUserModel";
    public static final String KEY_MSG_USER_NAME = "msgUserName";
    public static final String KEY_NOTIFICATION_MODEL_LIST = "NotificationsModelList";
    public static final String KEY_NOTE_TYPE = "note_type";
    public static final String KEY_MYPROFILE_ISFROMINSIDEAPP = "isfrominsideApp";
    public static final String KEY_ISCHATTING_WITH_FRIEND = "isChattingWithFriend";
    public static final String KEY_ISCHATTING_WITH_SYSTEM = "isChattingWithSystem";
    public static final String KEY_TIMELINE_USER_ID = "timeline_user_id";
    public static final String KEY_TIMELINE_USER_NAME = "timeline_user_name";
    public static final String KEY_MENTION_NAME = "mention_name";
    public static final String KEY_URLs = "url";
    public static final String KEY_IMAGES = "images";
    public static final String KEY_ORIGINAL_yoyo_MODEL = "orginalyoyoModel";
    public static final String KEY_IS_FOR_MESSAGING = "isForMessaging";
    public static final String KEY_GEO_ACCURACY = "GeoAccuracy";
    public static final String KEY_SHOULD_BE_REFRESHED_ON_BACK = "Should_be_refreshed_on_back";


//	other constants

    public static final String GPS_BROADCAST_LOCAL_TRENDING_yoyoS_NAME = "GPS_BROADCAST_LOCAL_TRENDING_yoyoS";
    public static final int IMAGE_TO_UPLOAD_MAX_FILE_SIZE_IN_KB = 500;
    public static final int IMAGE_TO_UPLOAD_HEIGHT = 400;
    public static final int IMAGE_TO_UPLOAD_WIDTH = 400;
    public static final int FACEBOOK_LOGIN_STATUS_ID = 1;
    public static final int TWITTER_LOGIN_STATUS_ID = 2;
    public static final int NORMAL_LOGIN_STATUS_ID = 3;
    public static final int PAGE_SIZE = 10;
    public static final int CHANNEL_FEEDS_PAGE_SIZE = 5;
    //    public static final int PAGE_SIZE_FOR_yoyoMAP_CHANNELS = 25;
    public static final int WEBSERVICE_TIMEOUT_VALUE_IN_MILLIS = 26000;   // 26 seconds
    public static final int BACKGROUND_SERVICE_INTERVAL_IN_MILLIS = 2*60000;   // 2 minutes
    public static final int SCREEN_REFRESH_TIMER_IN_MILLIS = 60000;   // 2 minutes
    public static final int SCREEN_REFRESH_DISTANCE_IN_METRES = 5000;
    public static final int MAXIMUM_DISTANCE_TO_REFRESH_IN_METRES = 3000;
    public static final int MinBattery = 15;
    public static final int T_GPS_Freq = 60;
    public static final int GPS_Freq = 300;
    public static final int LOCATION_SERVICE_INTERVAL_IN_MILLIS = 5*60*1000;   // 5 mins
    public static final String GpsAccuracy = "100";
    public static final long MAXIMUM_TIME_TO_UPDATE_CELLSITE_LOCATION_IN_MILLIS = 30*60*1000;


    public static final String APP_ID = "511689";
    public static final String SERVER_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TO_DISPLAY_TIME_FORMAT = "HH:mm";
    public static final String DEFAULT_USER_ID = "1";
    public static final boolean isDebugMode = false;
    public static final String FACEBOOK_PKG_NAME = "com.facebook.katana";
    public static final String TWITTER_PKG_NAME = "com.twitter.android";
    public static final int CHAT_SCREEN_AUTO_REFRESH_TIMER_IN_MILLISECONDS = 30000;
    public static final int IMAGE_UPLOAD_SOCKET_TIMEOUT_IN_SECONDS = 60;

    public static final String yoyoMAP_FACEBOOK_PAGE_NAME = "yoyoMap";
    public static final String yoyoMAP_TWITTER_HANDLE_NAME = "yoyoMap";
    public static final String yoyoMAP_TWITTER_PAGE_ID = "3252897161";
    public static final String yoyoMAP_URL_TNC = "https://www.yoyomap.com/tnc.php";
    public static final String yoyoMAP_URL_CONTACT_US = "2";

    public static final String FACEBOOK_PAGE_URL_PREFIX = "https://www.facebook.com/";
    public static final String TWITTER_PAGE_URL_PREFIX = "https://twitter.com/";
    public static final String UPLOADED_IMAGE_URL_PREFIX = "https://shsh.com/images/";
    public static final String UPLOADED_IMAGE_THUMBNAIL_URL_PREFIX = "https://shsh.com/images/tn/";
    //    public static final String UPLOADED_IMAGE_URL_PREFIX = "http://mm.yoyomap.com/images/";
    public static final String TAG_BACKGROUND_THREAD = "background_thread";


    public static final String LOG_TAG_CHANNEL_NAME_ISSUE = "channel_name_issue";
    public static final String PERMISSION_TAG = "Marshmallow_permission";
    public static final long CAMERA_IMAGE_MAX_DESIRED_SIZE_IN_BYTES = 1504970;
    public static final long TEST_CAMERA_IMAGE_MAX_DESIRED_SIZE_IN_BYTES = 2014000;
    public static final double CAMERA_IMAGE_MAX_SIZE_AFTER_COMPRESSION_IN_BYTES = 1893729.0;

}
