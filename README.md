![JTracker Logo](https://i.imgur.com/OJMd35U.png?1)

# Introduction
JTracker allows you to store an infinite number of websites to keep track of. Add a website that you are looking at to see if any changes occur. This application is great if you're wanting to see if any job openings become available, sales on an online store, or new news coming up.

## Limitations
- File reading and writing seems to keep UI from working faster.

### TODO:
- Being able to remove websites from within UI
- Edit websites through UI
- Implement the "Last Change" area in the table
- Look into speeding up UI, it's rather slow right now for some reason
- Replace alert boolean in table with a checkbox
- Clicking a link twice in the table will open it

# Future Plans
- Per website timer, each website can be set to a specific time to be checked. So you can check one more frequently than another.
- Instead of comparing html of pages, compare with a screenshot.
- Add webhook notifications for applications such as discord and slack

# Libraries Used
- Jsoup - https://jsoup.org/ 
    - Easily get the html document of a webpage
- yamlBeans - https://github.com/EsotericSoftware/yamlbeans 
    - Reading and writing of where the websites are stored
- TrayNotification - https://github.com/PlusHaze/TrayNotification
    - Shows notifications on platforms that do not support the java system tray.

# Running on Linux
If you are unable to run this app on a system running linux, make sure that you have
openJFX installed alongside openJDK if you do not have oracle java.

The command to get openJFX on Ubuntu is `sudo apt-get install openjfx`

# License
JTracker is licensed under the MIT license

Copyright (C) 2018 Jacob Cuomo
