step-1 : creat splash screen when user launch the applicton they'll be see some nice animation

step-2 : in AndroidManifest.xml
	* add internet permission (  <uses-permission android:name="android.permission.INTERNET"/>  )

step - 3 : in build.gridle(:app)
	* implement volly librery

step-3 : in ActivityMain.xml follow these steps
	* create imageview 
	* create next button 
	* create share button
	* create progressBar 

step-4 : in MainActivity.kt follow these steps
	* add volly request queue
	* add rendom meme generater API in activity 
	* add jason object request
	* add jason object request jpg to imageView 
	* add prograss bar when meme is loading the prograss bar is show on screen and when meme was loaded then prograss bar will be gone
	* implement  next button when user click  on it above four prosess will repeat.
	* implement share functionality when user press this button then one window pop up user select one of the given app and shre the meme
