### Introduction

This is a demo showing how to build a Fuse camel service following a contract first approach. This demo is based on the article [here](https://developers.redhat.com/blog/2019/07/09/api-first-design-with-openapi-and-red-hat-fuse) but uses my own database structure that I use in other demos.

### Creating the Open API Spec

To create the Open API specification we deploy the Red Hat API Designer into OpenShift. If you do not have OpenShift, you can use [APICurio](https://www.apicur.io/apicurito/pwa/) which is the upstream version of Red Hat API Designer.

To create an example of the Open API spec, click the New API button as per below:

![API Designer New API](https://raw.githubusercontent.com/gnunn1/product-catalog-fuse/master/docs/img/apidesigner-newapi.png)

And then click the "Add a data type" button as per below:

![API Designer New Data Type](https://raw.githubusercontent.com/gnunn1/product-catalog-fuse/master/docs/img/apidesigner-adddatatype.png)

Finally using the example provided below, fill out the screen as per the image.

```
{
    "id": 0,
    "name": "iPhone 12",
    "description": "Apple iPhone 12",
    "price": 999.99,
    "category_id": 0,
    "created": "2016-12-20",
    "modified": "2016-12-20 07:02:28.000000"
}
```

![API Designer New Data Type Example](https://raw.githubusercontent.com/gnunn1/product-catalog-fuse/master/docs/img/apidesigner-adddatatype.png)

Make sure the `Rest Resource` button is selected so that it will generate a skeleton CRUD interface for you.

At this point you can start tailoring the API as you see fit, a complete example is in the `stub/src/spec/product.json`.

### Building the code

To build the code, first you need to compile and generate the stub. You can do this using the following command:

```
cd stub
mvn package install
```

This will generate some classes including camel REST DSL routes. If you look at the generated code, you will see that the REST DSK invokes various direct routes. These are implemented in the fuse-impl project allowing us to keep our generated code separate from the implementation. This enables architects to iterate on the API design while minimizing the impact to developers.

Once you have compiled the stub you can then compile the implementation:

```
cd fuse-impl
mvn package
```

### Deploying the code to OpenShift

To deploy the code to OpenShift we will use a binary build, all of the manifests are provided in the `/manifests` folder. Deploying is simply using kustomize:

```
kustomize build manifests/app | oc apply -f -`