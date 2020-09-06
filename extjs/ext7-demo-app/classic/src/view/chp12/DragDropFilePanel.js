Ext.define('Ext7DemoApp.view.chp12.DragDropFilePanel', {
    extend: 'Ext.grid.Panel',
    xtype: 'dragdropfile',

    config: {
        multiple: true
    },
    selModel: {
        selType: 'rowmodel',
        mode: 'MULTI'
    },
    viewModel: {
        data: {}
    },
    columns: [{
        header: '文件名',
        dataIndex: 'name',
        flex: 2
    }, {
        header: '文件大小',
        dataIndex: 'size',
        flex: 1,
        renderer: Ext.util.Format.fileSize
    }],
    viewConfig: {
        emptyText: '拖拉文件到这里',
        deferEmptyText: false
    },
    store: {
        fileds: ['name', 'size', 'file', 'status']
    },
    initComponent: function () {
        var me = this;
        me.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                text: "清空文件",
                iconCls: 'x-fa fa-trash',
                handler: function (btn) {
                    me.getStore().reload();
                }
            }, {
                text: "移除选定文件",
                iconCls: 'x-fa fa-times',
                handler: function (btn) {
                    var store = me.getStore();
                    me.getStore().remove(me.getSelection());
                }
            }, {
                text: '增加文件',
                iconCls: 'x-fa fa-file',
                handler: function (btn) {
                    if (!me.inputField) {
                        me.inputField = me.createFileInput(me.store, me);
                    }
                    me.inputField.click();
                }
            }]
        }, {
            xtype: 'toolbar',
            dock: 'bottom',
            items: [{
                xtype: 'panel',
                hidden: true,
                items: [{
                    xtype: 'label',
                    html: '<span style="color: red;">Only one file can be upload.<span>'
                }]
            }]
        }];

        var listeners = me.store.listeners || {};
        listeners.datachanged = function (store, eOpts) {
            var len = store.getData().length;
            if (len > 0 && !me.multiple) {
                me.getDockedItems('toolbar[dock=top]')[0].items.items[2].setDisabled(true);
                return;
            }
            if (len == 0) {
                me.getDockedItems('toolbar[dock=top]')[0].items.items[2].setDisabled(false);
                return;
            }
        };
        me.store.listeners = listeners;
        me.callParent(arguments);

        me.on({
            drop: {
                element: 'el',
                fn: me.drop,
                scope: me
            },
            dragstart: {
                element: 'el',
                fn: me.addDropZone,
                scope: me
            },

            dragenter: {
                element: 'el',
                fn: me.addDropZone,
                scope: me
            },

            dragover: {
                element: 'el',
                fn: me.addDropZone,
                scope: me
            },

            dragleave: {
                element: 'el',
                fn: me.removeDropZone,
                scope: me
            },

            dragexit: {
                element: 'el',
                fn: me.removeDropZone,
                scope: me
            }
        });

    },

    createFileInput: function (store, ctx) {
        var inputEle = document.createElement('input');
        inputEle.type = 'file';
        inputEle.name = 'upload';
        inputEle.style.display = 'none';
        inputEle.multiple = ctx.multiple;
        inputEle.addEventListener('change', function (input) {
            if (!input.target.files) {
                return;
            }
            var files = input.target.files;
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                store.add({
                    file: file,
                    name: file.name,
                    size: file.size,
                    status: 'Ready'
                });
            }
            document.body.removeChild(inputEle);
            ctx.inputField = null;
        });
        document.body.append(inputEle);
        return inputEle;
    },


    noop: function (e) {
        e.stopEvent();
    },

    addDropZone: function (e) {
        if (!e.browserEvent.dataTransfer || Ext.Array.from(e.browserEvent.dataTransfer.types).indexOf('Files') === -1) {
            return;
        }

        e.stopEvent();

        this.addCls('drag-over');
    },

    removeDropZone: function (e) {
        var el = e.getTarget(),
            thisEl = this.getEl();

        e.stopEvent();


        if (el === thisEl.dom) {
            this.removeCls('drag-over');
            return;
        }

        while (el !== thisEl.dom && el && el.parentNode) {
            el = el.parentNode;
        }

        if (el !== thisEl.dom) {
            this.removeCls('drag-over');
        }

    },

    drop: function (e) {
        e.stopEvent();
        var me = this,
            store = me.getStore();
        if (!this.multiple && store.getData().length > 0) {
            me.getDockedItems('toolbar[dock=bottom]')[0].items.items[0].setHidden(false);
            me.removeCls('drag-over');
            return;
        }
        var count = 0;
        Ext.Array.forEach(Ext.Array.from(e.browserEvent.dataTransfer.files), function (file) {
            if (!me.multiple && count > 0) {
                return false;
            }
            store.add({
                file: file,
                name: file.name,
                size: file.size,
                status: 'Ready'
            });
            count++;
        });
        me.removeCls('drag-over');
    },
});