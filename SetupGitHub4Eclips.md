# Set up GitHub in Eclipse

1. Open Eclipse (My version comes with Github client built-in)
2. Open Git perspective \
   <img src="resources/git-perspective.jpg" width="300"/>
3. clone the Git repository - click `"Clone a Git repository"` \
   <img src="resources/git-clone.jpg" width="300"/>
4. Copy git repos url from Github \
   <img src="resources/clone-1.jpg" width="600"/>ß
5. Enter URL and credentials in Eclipse Git clone window \
   <img src="resources/clone-2.png" width="600"/>\
   Next -> Next -> \
   <img src="resources/clone-3.png" width="600"/>\
   Enter the local secure store password \
   <img src="resources/clone-4.jpg" width="400"/>
6. Note: Please check the `"Store in Secure Store"` to save your credentials to the local secure store to avoid entering credentials every time pushing date to Github. If encounters this error `"Failed to write credentials for 'your git repo URL' to secure store No password provided."`, please go `Preferences->General->Security->Secure Storage` uncheck the highlighted item: \
   <img src="resources/securestorage.png" width="600"/>
7. Now the Github repository is cloned and you are ready to deliver your code to Github.

