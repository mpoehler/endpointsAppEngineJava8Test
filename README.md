# Endpoints Test

Small project to test 
- Google Cloud Endpoints 
- with Google AppEngine Standard Environment (Java8)

Build with gradle, especially
- [appengine-gradle-plugin](https://github.com/GoogleCloudPlatform/app-gradle-plugin)
- [endpoints-framework-gradle-plugin](https://github.com/GoogleCloudPlatform/endpoints-framework-gradle-plugin)

**The project currently works as expected when deployed [Try here](https://endpointstest-169017.appspot.com/), but doesn't work locally.**

## Setup

You need to adopt the following to deploy it on you own.

- in /common.gradle, replace cliendId and appId with your settings from the cloud console.
- in src/main/webapp/index.html, replace the hostname of your app.
- in src/main/de.klpv.api.config.Constants, replace the clientId.

## Run locally (dev-server)

First you need to comment the `<runtime>java8</runtime>` like `<!--runtime>java8</runtime-->` to use the java7 dev server.

If you don't comment the java8 runtime, you'll get the following exception: 
`
2017-08-28 16:45:23.068:WARN:oejs.ServletHandler:qtp386163331-18: Error for /_ah/api/discovery/v1/apis/klpvApi/v2/rest
java.lang.NoClassDefFoundError: com/google/appengine/repackaged/org/codehaus/jackson/node/ObjectNode
        at java.lang.Class.getDeclaredConstructors0(Native Method)
        at java.lang.Class.privateGetDeclaredConstructors(Class.java:2671)
        at java.lang.Class.getConstructor0(Class.java:3075)
        at java.lang.Class.newInstance(Class.java:412)
        at org.eclipse.jetty.server.handler.ContextHandler$Context.createInstance(ContextHandler.java:2481)
        at org.eclipse.jetty.servlet.ServletContextHandler$Context.createServlet(ServletContextHandler.java:1327)
        at org.eclipse.jetty.servlet.ServletHolder.newInstance(ServletHolder.java:1285)
        at org.eclipse.jetty.servlet.ServletHolder.initServlet(ServletHolder.java:615)
        at org.eclipse.jetty.servlet.ServletHolder.getServlet(ServletHolder.java:499)
        at org.eclipse.jetty.servlet.ServletHolder.ensureInstance(ServletHolder.java:791)
        at org.eclipse.jetty.servlet.ServletHolder.prepare(ServletHolder.java:776)
        at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:579)
        at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
        at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:524)
        at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:226)
        at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1180)
        at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:512)
        at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:185)
        at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1112)
        at com.google.appengine.tools.development.jetty9.DevAppEngineWebAppContext.doScope(DevAppEngineWebAppContext.java:94)
        at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
        at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:134)
        at com.google.appengine.tools.development.jetty9.JettyContainerService$ApiProxyHandler.handle(JettyContainerService.java:597)
        at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:134)
        at org.eclipse.jetty.server.Server.handle(Server.java:534)
        at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:320)
        at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:251)
        at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:283)
        at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:108)
        at org.eclipse.jetty.io.SelectChannelEndPoint$2.run(SelectChannelEndPoint.java:93)
        at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.executeProduceConsume(ExecuteProduceConsume.java:303)
        at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.produceConsume(ExecuteProduceConsume.java:148)
        at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.run(ExecuteProduceConsume.java:136)
        at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:671)
        at org.eclipse.jetty.util.thread.QueuedThreadPool$2.run(QueuedThreadPool.java:589)
        at java.lang.Thread.run(Thread.java:745)
`

When the entry is commented, you can just start the local dev server: 

`
gradle appengineRun
`

Then try <http://localhost:8080> and you should see an alert with "Hi Marco".
 
## Deployment



`
gradle appengineDeploy
` 

Then try the URL of your app and you should see "Hi Marco".








 
