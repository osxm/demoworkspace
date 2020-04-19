/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
Ext.application({
    extend: 'Ext7DemoApp.Application',

    name: 'Ext7DemoApp',

    requires: [
        // This will automatically load all classes in the Ext7DemoApp namespace
        // so that application classes do not need to require each other.
        'Ext7DemoApp.*'
    ],

    // The name of the initial view to create.
    mainView: 'Ext7DemoApp.view.main.Main'
});
