uf-js
=====

Uberfire JS Angular Integrations Demo

Blog post: http://blog.athico.com/2014/11/red-hat-jboss-brms-and-bpms-rich-client.html

Demo video:     https://www.youtube.com/watch?v=jDpmMeFO_q8&feature=youtu.be&list=PLOwIXYCm38DklIzT8E7qKmW1kNQA4N7vN

0. Git clone our project

	git clone git@github.com:ederign/uf-js.git



Uberfire Client Only:
=====================


1. bower install uf-js 

    Note: You probably want to start in an empty directory;




2. cd bower_components/uf-js/



3. Open ../bower_components/uf-js/index.html on Firefox 

    Note: We use firefox here, only because Chrome doesn't allow different protocols requests file:// and http://


4. Try Uberfire Screens:

- Screens hello World

    <!-- Uberfire Component-->
    <uberfirecomponent id="id1" uf-component="welcome"></uberfirecomponent>
    <!-- <uberfireperspective id="id1" uf-component="HomePerspective"></uberfirecomponent> -->

- Passing parameters from angular to uberfire

    <!-- Uberfire Component-->
    <uberfirecomponent id="id1" name="John Connor" uf-component="welcome"></uberfirecomponent>
    <!-- <uberfireperspective id="id1" uf-component="HomePerspective"></uberfirecomponent> -->




5. Try Uberfire Perspectives
   
    <!-- Uberfire Component-->
    <!-- <uberfirecomponent id="id1" name="John Connor" uf-component="welcome"></uberfirecomponent> -->
    <uberfireperspective id="id1" uf-component="HomePerspective"></uberfirecomponent>:
    


Uberfire Full Distribution + Angular:
====================================


Using JBoss:
------------
Demo video: https://www.youtube.com/watch?v=mXMny4AuHIU


1-) Download our compiled War for EAP 7.1 (jboss-as-7.1.1.Final)

https://www.dropbox.com/s/hddyv03ep1su4nm/uberfire.war?dl=0

2-) Install this war in EAP

3-) To make angular routes work, you have to install (map) the directory angular-poc inside some web server (like apache). In my example I map angular-poc inside apache so the url will be:

http://127.0.0.1/angular-poc/indexExternal.html


4-) Create a dynamic screen like this video:

https://www.youtube.com/watch?v=JQvC0CBDFCM

With parameters:
angularTemplateUrl http://127.0.0.1/angular-poc/secondNestedController.html
domElementId template
Place Name ExternalAngularScreen

Note: there is a small bug, that the component only save the value after um click outside the field, so before click on close, please click somewhere in the popup to the component lost focus

Hit close;

Click on save perspective
pespective name: dynamicPerspective


6-) Access menu Nested Controllers

See the nested controllers in action, is a external angular component, with a uberfire perspective that has a angular component inside it. Transparent integration!


Compiling and running in Jetty:
------------------------------

1. Clone and Build Uberfire Fork
    git clone git@github.com:ederign/uberfire.git
    mvn clean install -Dmaven.test.skip=true

2. Build kie-uberfire-js-webapp project
    mvn clean install

    Note:  worth mentioning kie-uberfire-js-webapp is back in the uf-js git repo we cloned in an earlier section (not in the uberfire fork we built)

3. Run it and open the url in Google Chrome 
    mvn gwt:run
	http://127.0.0.1:8888/angular-poc/indexLocal.html?gwt.codesvr=127.0.0.1:9997

4. You can now see the perspective editor, and angular routes working. (right now, only between home and perspective editor)


5-) Create a dynamic screen like this video:

https://www.youtube.com/watch?v=JQvC0CBDFCM

With parameters:
angularTemplateUrl http://127.0.0.1:8888/angular-poc/secondNestedController.html
domElementId template
Place Name ExternalAngularScreen

(there is a small bug, that the component only save the value after um click outside the field, so before click on close, please click somewhere in the popup to the component lost focus)

Hit close;

Click on save perspective
pespective name: dynamicPerspective


6-) Access menu Nested Controllers

See the nested controllers in action, is a external angular component, with a uberfire perspective that has a angular component inside it. Transparent integration!









