# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
    public *;
}

-keepnames class * implements android.os.Parcelable {
    public <methods>; <fields>;
}

-keepnames class com.shockwave.**

-keep class com.appsflyer.** { *; }