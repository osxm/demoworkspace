/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
Ext.application({
    extend: 'Ext73App.Application',

    name: 'Ext73App',

    requires: [
        // This will automatically load all classes in the Ext73App namespace
        // so that application classes do not need to require each other.
        'Ext73App.*'
    ],

    // The name of the initial view to create.
    mainView: 'Ext73App.view.main.Main'
});
