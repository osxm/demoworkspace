Ext.define('Ext7DemoApp.view.chp12.WidgetColGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'wigetcolgrid',
    title:'带有编辑列的Grid',
    viewCols: [{
        width: 30,
        xtype: 'actioncolumn',
        items: [{
            iconCls: 'x-fa fa-trash-alt',
            tooltip: 'Delete Feature',
            handler: function (grid, rowIndex, colIndex) {
                grid.getStore().load();
            }
        }]
    }, {
        text: 'Name',
        dataIndex: 'name',
        flex: 2
    }, {
        text: 'City',
        dataIndex: 'city',
        flex: 1
    }],
    editCols: [{
        text: 'Name',
        dataIndex: 'name',
        sortable: false,
        flex: 1
    }, {
        text: 'City',
        dataIndex: 'city',
        flex: 1,
        minWidth: 82,
        sortable: false,
        xtype: 'widgetcolumn',
        widget: {
            xtype: 'combobox',
            bind: '{record.city}',
            forceSelection: true
        },
        onWidgetAttach: function (col, widget, rec) {
            var citys = rec.get("citys");
            var cityArray = Ext.decode(citys);
            widget.setStore(cityArray);
        }
    }],
    constructor: function (config) {
        config = config || {};

        config.columns = this.viewCols;
        this.callParent([config]);
    }, store: {
        type: 'WidgetColGrid'
    }, tbar: [{
        text: 'Edit',
        handler: function (thisBtn) {
            var grid = thisBtn.findParentByType("grid");
            grid.reconfigure(grid.editCols);
        }
    }, {
        text: 'Save',
        handler: function (thisBtn) {
            var grid = thisBtn.findParentByType("grid");
            var modifyModels = grid.getStore().getModifiedRecords();
            grid.reconfigure(grid.viewCols);
        }
    }]

});