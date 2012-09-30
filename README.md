# Drupal Services API Client (Java)
This library is an easy-to-use Java client library for accessing the Drupal [Services](http://drupal.org/project/services) module APIs using the REST interface.

## Installation
```shell
mvn clean install;
```

If using Maven:
```xml
<dependency>
    <groupId>dk.i2m.drupal</groupId>
    <artifactId>services-api-client</artifactId>
    <version>1.0</version>
    <scope>compile</scope>
</dependency>


<repositories>
    <repository>
        <id>m2.i2m.dk</id>
        <name>I2M Maven Repository</name>
        <url>http://m2.i2m.dk</url>
    </repository>
</repositories>

```

## Usage
```java
import dk.i2m.services.drupal.core.DrupalClient;
import dk.i2m.services.drupal.fields.wrappers.*;
import dk.i2m.services.drupal.resources.*;
import dk.i2m.services.drupal.util.HttpMessageBuilder;
```
Create a new language neutral (und) HttpMessageBuilder. See [LANGUAGE_NONE](http://api.drupal.org/api/drupal/includes!bootstrap.inc/constant/LANGUAGE_NONE):
```java
HttpMessageBuilder fb = new HttpMessageBuilder("und"); // Same as calling: new HttpMessageBuilder();
```
Add fields using the `add()` method:
```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = Calendar.getInstance().getTime();

fb
        .add(new BasicWrapper("title", "Example Node"))   // Mandatory
        .add(new BasicWrapper("type", "article"))         // Mandatory
        .add(new BasicWrapper("status", "1"))
        .add(new BasicWrapper("date", sdf.format(date)))  // Drupal defaults to the created date
        .add(new TextWrapper("body", "Summary text", "<p>Lorem ipsum dolor sit amet...</p>", "full_html"))
        .add(new TextWrapper("field_text_1", "Fruits, Apples, Oranges"))
        .add(new TextWrapper("field_text_2", "Apple"))
        .add(new NumberWrapper("field_number", "942342"))
        .add(new OptionWrapper("field_option", Boolean.TRUE))
        .add(new ListWrapper("field_list", "sample"));
```
`fb.toString();` for the above will give you:
```
language                    = und,
status                      = 1, 
title                       = Example Node, 
type                        = article
date                        = 2012-08-09 13:32:19,
body[und][0][format]        = full_html, 
body[und][0][summary]       = Summary text,
body[und][0][value]         = <p>Lorem ipsum dolor sit amet...</p>, 
field_list[und][0]          = sample, 
field_number[und][0][value] = 942342, 
field_option[und][0]        = 1, 
field_text_1[und][0][value] = Fruits, Apples, Oranges, 
field_text_2[und][0][value] = Apple
```
### Creating resources
**Currently the client has support for only creating file and node resources.**

Create a DrupalClient. You can use the provided DefaultDrupalClient or create your own by extending `dk.i2m.services.drupal.core.AbstractDrupalClient`.
```java
// Create a new DrupalClient using the Drupal hostname and services endpoint
DrupalClient dc = new DefaultDrupalClient(URI.create("http://www.example.com"), "endpoint");
```
#### Node
Depending on your setup, you may need to login using a UserResource.
```java
UserResource ur = new UserResource(dc, "username", "password");
NodeResource nr = new NodeResource(dc);

try {
    // Login user
    ur.login();

    // Use the create() method to create a node
    NodeResponse response = nr.create(fb.toUrlEncodedFormEntity());
    System.out.println(response.getId());   // NID e.g. 43
    System.out.println(response.getUri());  // URI e.g. http://www.example.com/node/43
    
    // Logout user
    ur.logout();
} catch (MalformedURLException ex) {
    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
} catch (ClientProtocolException ex) {
    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
} catch (UnsupportedEncodingException ex) {
    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
}
```
#### File
TODO: Add example
### Multiple Value Fields
```java
import dk.i2m.services.drupal.fields.*;
```
Build a wrapper and use the `add()` method to add values:
```java
// Create a new TextWrapper for the field_text_3 text field
TextWrapper textWrapper = new TextWrapper("field_text_3");
textWrapper.add(new Text("Value 1")); // Add a new value
textWrapper.add(new Text("Value 2"));
textWrapper.add(new Text("Value 3"));
```
Add it to the HttpMessageBuilder (see above):
```java
fb.add(textWrapper);
```
`fb.toString();` for the above will give you:
```
field_text_3[und][0][value] = Value 1, 
field_text_3[und][1][value] = Value 2,
field_text_3[und][2][value] = Value 3
```

## Testing
Not yet implemented

## Contributing

1. Fork it.
2. Create a branch (`git checkout -b my_contribution`)
3. Commit your changes (`git commit -am "Added Contribution"`)
4. Push to the branch (`git push origin my_contribution`)
5. Open a [Pull Request][1]
6. Enjoy a refreshing Diet Coke and wait

[1]: http://scm.i2m.dk/drupal-services-api/pull-request/new
