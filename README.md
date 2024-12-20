Vyson Shorton url making
﻿
To Create the Shorton URL pass the URL: 
POST
Create the shorten URL
http://192.168.1.91.:8080/URLConverter/shorten
Body
    {
    "longUrl" : "https://www.google.com/search?q=zomato+share+price&rlz=1C1GCEU_enIN1105IN1105&oq
    =&gs_lcrp=EgZjaHJvbWUqBggBEEUYOzIGCAAQRRg5MgYIARBFGDsyBggCEEUYOzINCAMQABixAxjJAxiABDINCAQQABiDARixAxiABDINCAUQABiSAxixAxiABDINCAYQABiSAxiABBiKBTIKCAcQABixAxiABDINCAgQABiDARixAxiABDIKCAkQABixAxiABNIBCDIxMzdqMGo3qAIAsAIA&sourceid
    =chrome&ie=UTF-8"
    }

    
GET to access the same url with the shrten url 

Access the site with the shorten url
http://192.168.1.91:8080/URLConverter/b
