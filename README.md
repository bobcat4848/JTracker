![JTracker Logo](https://i.imgur.com/OJMd35U.png?1)

# Introduction
JTracker allows you to store an infinite number of websites to keep track of. Add a website that you are looking at to see if any changes occur. This application is great if you're wanting to see if any job openings become available, sales on an online store, or new news coming up.

## Limitations
- File reading and writing seems to keep UI from working faster.

### TODO:
- Add options panel that will allow users to control certain aspects of the program like how frequent it should check if there is a change to a website.
- Being able to remove websites from within UI
- Look into speeding up UI, it's rather slow right now for some reason
- Replace alert boolean in table with a checkbox
- Clicking a link twice in the table will open it

# Future Plans
- Add screenshot region of website to see if any changes occur in a certain region of a webpage.

# Libraries Used
- Jsoup - https://jsoup.org/ Allowed me to easily get the html document of a webpage
- yamlBeans - https://github.com/EsotericSoftware/yamlbeans Handles the reading and writing of where the websites are stored

# License
JTracker is licensed under the MIT license

Copyright (C) 2018 Jacob Cuomo
