# ImageDetailsLibs
```sh
Using this library you can get image properties after capturing image.
Like....
Bitmap, Url, Real Path, Actual Path.
Image size, width, height, extension type & name.
Also you get ExifInterface, that may provide you all external information about the image.
```

## Developed By
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27) 

# ★ Gradle Dependency
```sh
Add Gradle dependency in the build.gradle file of your application module (app in the most cases) : First Tab:
allprojects{
    repositories{
        jcenter()
        maven {
            url 'https://jitpack.io'
        }
    }
}
AND
dependencies {
    implementation 'com.github.SandipLayek27:ImageDetailsLibs:1.3'
}
```
## Android Code Setup
```sh
★ Static variable load
private static final int CAMERA_REQUEST = 1888;

★ Call Barcode scanner activity
Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(cameraIntent, CAMERA_REQUEST);

★ Fetch Response
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
        ImageInformation imageInformation = new ImageInformation(MainActivity.this);
        // FETCH BASIC INFORMATION
        // IF YOU WANT TO SET IMAGE TO IMAGE VIEW
        Bitmap bitmapPhoto = imageInformation.setImageToImageView(ivPreview,data);
        
        // IF YOU ONLY GET BITMAP IMAGE THEN YOU SET MANUALLY
        Bitmap bitmapPhoto1 = imageInformation.getBitmapFormatImage(data);

        Uri uri = imageInformation.getImageUri(bitmapPhoto);
        // SET DYNAMIC QUALITY
        Uri uriDynamicQuality = imageInformation.getImageUri(bitmapPhoto,50);

        String realPath = imageInformation.getRealPathFromURI(uri);
        File file = imageInformation.getActualPath(realPath);
        byte[] fileInBytes = imageInformation.getFileInByteArray(realPath);
        Bitmap bitmapFromByteArray = imageInformation.getBitmapFromByteArray(fileInBytes);

        // IMAGE PROP SECTION CALL
        long size = imageInformation.getFileSizeInKB(file);
        int height = imageInformation.getImageFileHeight(bitmapPhoto);
        int width = imageInformation.getImageFileWidth(bitmapPhoto);
        String ext = imageInformation.getFileExtension(realPath);
        String fileName = imageInformation.getFileName(realPath);

        
      
        ExifInterface exifInterface = imageCaptureDate(realPath);
        String TAG_ARTIST = exifInterface.TAG_ARTIST;
        // USE BELOW PROPERTIES FOR GET EXTERNAL INFORMATION ABOUT CAPTURED IMAGE
        -------------------------------------------------------------------------------
        int	ORIENTATION_FLIP_HORIZONTAL
        int	ORIENTATION_FLIP_VERTICAL
        int	ORIENTATION_NORMAL
        int	ORIENTATION_ROTATE_180
        int	ORIENTATION_ROTATE_270
        int	ORIENTATION_ROTATE_90
        int	ORIENTATION_TRANSPOSE
        int	ORIENTATION_TRANSVERSE
        int	ORIENTATION_UNDEFINED
        int	STREAM_TYPE_EXIF_DATA_ONLY
        Constant used to indicate that the input stream contains only Exif data.

        int	STREAM_TYPE_FULL_IMAGE_DATA
        Constant used to indicate that the input stream contains the full image data.

        String	TAG_APERTURE
        This constant was deprecated in API level 24. use TAG_F_NUMBER instead

        String	TAG_APERTURE_VALUE
        Type is rational.

        String	TAG_ARTIST
        Type is String.

        String	TAG_BITS_PER_SAMPLE
        Type is int.

        String	TAG_BRIGHTNESS_VALUE
        Type is rational.

        String	TAG_CFA_PATTERN
        Type is String.

        String	TAG_COLOR_SPACE
        Type is int.

        String	TAG_COMPONENTS_CONFIGURATION
        Type is String.

        String	TAG_COMPRESSED_BITS_PER_PIXEL
        Type is rational.

        String	TAG_COMPRESSION
        Type is int.

        String	TAG_CONTRAST
        Type is int.

        String	TAG_COPYRIGHT
        Type is String.

        String	TAG_CUSTOM_RENDERED
        Type is int.

        String	TAG_DATETIME
        Type is String.

        String	TAG_DATETIME_DIGITIZED
        Type is String.

        String	TAG_DATETIME_ORIGINAL
        Type is String.

        String	TAG_DEFAULT_CROP_SIZE
        Type is int.

        String	TAG_DEVICE_SETTING_DESCRIPTION
        Type is String.

        String	TAG_DIGITAL_ZOOM_RATIO
        Type is double.

        String	TAG_DNG_VERSION
        Type is int.

        String	TAG_EXIF_VERSION
        Type is String.

        String	TAG_EXPOSURE_BIAS_VALUE
        Type is double.

        String	TAG_EXPOSURE_INDEX
        Type is rational.

        String	TAG_EXPOSURE_MODE
        Type is int.

        String	TAG_EXPOSURE_PROGRAM
        Type is int.

        String	TAG_EXPOSURE_TIME
        Type is double.

        String	TAG_FILE_SOURCE
        Type is String.

        String	TAG_FLASH
        Type is int.

        String	TAG_FLASHPIX_VERSION
        Type is String.

        String	TAG_FLASH_ENERGY
        Type is rational.

        String	TAG_FOCAL_LENGTH
        Type is rational.

        String	TAG_FOCAL_LENGTH_IN_35MM_FILM
        Type is int.

        String	TAG_FOCAL_PLANE_RESOLUTION_UNIT
        Type is int.

        String	TAG_FOCAL_PLANE_X_RESOLUTION
        Type is rational.

        String	TAG_FOCAL_PLANE_Y_RESOLUTION
        Type is rational.

        String	TAG_F_NUMBER
        Type is double.

        String	TAG_GAIN_CONTROL
        Type is int.

        String	TAG_GPS_ALTITUDE
        The altitude (in meters) based on the reference in TAG_GPS_ALTITUDE_REF.

        String	TAG_GPS_ALTITUDE_REF
        0 if the altitude is above sea level.

        String	TAG_GPS_AREA_INFORMATION
        Type is String.

        String	TAG_GPS_DATESTAMP
        Type is String.

        String	TAG_GPS_DEST_BEARING
        Type is rational.

        String	TAG_GPS_DEST_BEARING_REF
        Type is String.

        String	TAG_GPS_DEST_DISTANCE
        Type is rational.

        String	TAG_GPS_DEST_DISTANCE_REF
        Type is String.

        String	TAG_GPS_DEST_LATITUDE
        Type is rational.

        String	TAG_GPS_DEST_LATITUDE_REF
        Type is String.

        String	TAG_GPS_DEST_LONGITUDE
        Type is rational.

        String	TAG_GPS_DEST_LONGITUDE_REF
        Type is String.

        String	TAG_GPS_DIFFERENTIAL
        Type is int.

        String	TAG_GPS_DOP
        Type is rational.

        String	TAG_GPS_IMG_DIRECTION
        Type is rational.

        String	TAG_GPS_IMG_DIRECTION_REF
        Type is String.

        String	TAG_GPS_LATITUDE
        Type is rational.

        String	TAG_GPS_LATITUDE_REF
        Type is String.

        String	TAG_GPS_LONGITUDE
        Type is rational.

        String	TAG_GPS_LONGITUDE_REF
        Type is String.

        String	TAG_GPS_MAP_DATUM
        Type is String.

        String	TAG_GPS_MEASURE_MODE
        Type is String.

        String	TAG_GPS_PROCESSING_METHOD
        Type is String.

        String	TAG_GPS_SATELLITES
        Type is String.

        String	TAG_GPS_SPEED
        Type is rational.

        String	TAG_GPS_SPEED_REF
        Type is String.

        String	TAG_GPS_STATUS
        Type is String.

        String	TAG_GPS_TIMESTAMP
        Type is String.

        String	TAG_GPS_TRACK
        Type is rational.

        String	TAG_GPS_TRACK_REF
        Type is String.

        String	TAG_GPS_VERSION_ID
        Type is String.

        String	TAG_IMAGE_DESCRIPTION
        Type is String.

        String	TAG_IMAGE_LENGTH
        Type is int.

        String	TAG_IMAGE_UNIQUE_ID
        Type is String.

        String	TAG_IMAGE_WIDTH
        Type is int.

        String	TAG_INTEROPERABILITY_INDEX
        Type is String.

        String	TAG_ISO
        This constant was deprecated in API level 24. use TAG_ISO_SPEED_RATINGS instead

        String	TAG_ISO_SPEED_RATINGS
        Type is int.

        String	TAG_JPEG_INTERCHANGE_FORMAT
        Type is int.

        String	TAG_JPEG_INTERCHANGE_FORMAT_LENGTH
        Type is int.

        String	TAG_LIGHT_SOURCE
        Type is int.

        String	TAG_MAKE
        Type is String.

        String	TAG_MAKER_NOTE
        Type is String.

        String	TAG_MAX_APERTURE_VALUE
        Type is rational.

        String	TAG_METERING_MODE
        Type is int.

        String	TAG_MODEL
        Type is String.

        String	TAG_NEW_SUBFILE_TYPE
        Type is int.

        String	TAG_OECF
        Type is String.

        String	TAG_OFFSET_TIME
        A tag used to record the offset from UTC (the time difference from Universal Time Coordinated including daylight saving time) of the time of DateTime tag.

        String	TAG_OFFSET_TIME_DIGITIZED
        A tag used to record the offset from UTC (the time difference from Universal Time Coordinated including daylight saving time) of the time of DateTimeDigitized tag.

        String	TAG_OFFSET_TIME_ORIGINAL
        A tag used to record the offset from UTC (the time difference from Universal Time Coordinated including daylight saving time) of the time of DateTimeOriginal tag.

        String	TAG_ORF_ASPECT_FRAME
        Type is int.

        String	TAG_ORF_PREVIEW_IMAGE_LENGTH
        Type is int.

        String	TAG_ORF_PREVIEW_IMAGE_START
        Type is int.

        String	TAG_ORF_THUMBNAIL_IMAGE
        Type is undefined.

        String	TAG_ORIENTATION
        Type is int.

        String	TAG_PHOTOMETRIC_INTERPRETATION
        Type is int.

        String	TAG_PIXEL_X_DIMENSION
        Type is int.

        String	TAG_PIXEL_Y_DIMENSION
        Type is int.

        String	TAG_PLANAR_CONFIGURATION
        Type is int.

        String	TAG_PRIMARY_CHROMATICITIES
        Type is rational.

        String	TAG_REFERENCE_BLACK_WHITE
        Type is rational.

        String	TAG_RELATED_SOUND_FILE
        Type is String.

        String	TAG_RESOLUTION_UNIT
        Type is int.

        String	TAG_ROWS_PER_STRIP
        Type is int.

        String	TAG_RW2_ISO
        Type is int.

        String	TAG_RW2_JPG_FROM_RAW
        Type is undefined.

        String	TAG_RW2_SENSOR_BOTTOM_BORDER
        Type is int.

        String	TAG_RW2_SENSOR_LEFT_BORDER
        Type is int.

        String	TAG_RW2_SENSOR_RIGHT_BORDER
        Type is int.

        String	TAG_RW2_SENSOR_TOP_BORDER
        Type is int.

        String	TAG_SAMPLES_PER_PIXEL
        Type is int.

        String	TAG_SATURATION
        Type is int.

        String	TAG_SCENE_CAPTURE_TYPE
        Type is int.

        String	TAG_SCENE_TYPE
        Type is String.

        String	TAG_SENSING_METHOD
        Type is int.

        String	TAG_SHARPNESS
        Type is int.

        String	TAG_SHUTTER_SPEED_VALUE
        Type is rational.

        String	TAG_SOFTWARE
        Type is String.

        String	TAG_SPATIAL_FREQUENCY_RESPONSE
        Type is String.

        String	TAG_SPECTRAL_SENSITIVITY
        Type is String.

        String	TAG_STRIP_BYTE_COUNTS
        Type is int.

        String	TAG_STRIP_OFFSETS
        Type is int.

        String	TAG_SUBFILE_TYPE
        Type is int.

        String	TAG_SUBJECT_AREA
        Type is int.

        String	TAG_SUBJECT_DISTANCE
        Type is double.

        String	TAG_SUBJECT_DISTANCE_RANGE
        Type is int.

        String	TAG_SUBJECT_LOCATION
        Type is int.

        String	TAG_SUBSEC_TIME
        Type is String.

        String	TAG_SUBSEC_TIME_DIG
        This constant was deprecated in API level 24. use TAG_SUBSEC_TIME_DIGITIZED instead

        String	TAG_SUBSEC_TIME_DIGITIZED
        Type is String.

        String	TAG_SUBSEC_TIME_ORIG
        This constant was deprecated in API level 24. use TAG_SUBSEC_TIME_ORIGINAL instead

        String	TAG_SUBSEC_TIME_ORIGINAL
        Type is String.

        String	TAG_THUMBNAIL_IMAGE_LENGTH
        Type is int.

        String	TAG_THUMBNAIL_IMAGE_WIDTH
        Type is int.

        String	TAG_THUMBNAIL_ORIENTATION
        Type is int.

        String	TAG_TRANSFER_FUNCTION
        Type is int.

        String	TAG_USER_COMMENT
        Type is String.

        String	TAG_WHITE_BALANCE
        Type is int.

        String	TAG_WHITE_POINT
        Type is rational.

        String	TAG_XMP
        Type is byte[].

        String	TAG_X_RESOLUTION
        Type is rational.

        String	TAG_Y_CB_CR_COEFFICIENTS
        Type is rational.

        String	TAG_Y_CB_CR_POSITIONING
        Type is int.

        String	TAG_Y_CB_CR_SUB_SAMPLING
        Type is int.

        String	TAG_Y_RESOLUTION
        Type is rational.

        int	WHITEBALANCE_AUTO
        int	WHITEBALANCE_MANUAL
        
    }
}
```
