Ext.define('Sbi.chart.designer.ChartConfigurationPalette', {
    alternateClassName: ['ChartConfigurationPalette'],
	extend : 'Ext.panel.Panel',
	columnWidth: 0.3,
	title : LN('sbi.chartengine.configuration.palette'),
	bodyPadding : 10,
	items : [],

	paletteGrid : {},
	
	statics: {
		idSeed: 0
	},
	
	constructor: function(config) {
        this.callParent(config);
        
        var colorPalette = config.colorPalette;
        
        this.paletteGrid = Ext.create('Ext.grid.Panel', {
    	    store: Ext.create('Ext.data.ArrayStore', {
            	storeId: 'chartConfigurationPaletteStore',
            	
            	fields: ['id', 'gradient','name','order','value']
            }),
    	    
    	    width: 180,
    	    margin:'0 10 0 0',
    	    multiSelect: true,
    	    columns: [{
    	        text     : LN('sbi.chartengine.configuration.color'),
    	        flex     : 1,
    	        sortable : false,
    	        dataIndex: 'value',
    	        renderer : function(value, meta) {
    	        	meta.style = "background-color:#"+value+";";
    	        }
    	    }]
    	});
        
        // Reset
        this.paletteGrid.store.loadData({});
		// Load json colors
        this.paletteGrid.store.setData(colorPalette);
		
		
        var grid = this.paletteGrid;
		var item = [{
	        xtype : 'fieldcontainer',
	        layout : 'hbox',
	        items: [
	           	grid,	
	        {
	            xtype : 'fieldcontainer',
	        	layout : 'vbox',
	            defaults: {
	                arrowCls: '',
	                width: 22
	            },
	            items: [{
	                xtype : 'button',
	                text: '+',
	                menu : Ext.create('Ext.menu.ColorPicker',{
	                    listeners : {
	                        select : function(picker, selColor) {

	                        	var order = 0;
	                        	if(grid.store.data && grid.store.data.items) {
	                        		order = grid.store.data.length > 0? 
	                        				grid.store.getAt(grid.store.data.items.length-1).get('order') + 1
	                        				: 1;
	                        	}
	                        	
	                        	grid.store.add({
	                        		id: 'addedColor_' + ChartConfigurationPalette.idSeed,
	                            	gradient:'',
	                            	name: 'addedColor_' + ChartConfigurationPalette.idSeed++,
	                            	order: order,
	                            	value: selColor
	                            });
	                        }
	                    }
	                }),                 
	            },{
	                xtype : 'button',
	                text: '-',
	                handler: function(){
	                    var selectedRows = grid.getSelectionModel().getSelection();
	                    if (selectedRows.length) {
	                    	grid.store.remove(selectedRows);
	                    	console.log('removed from grid.store: ', grid.store);
	                    } else {
	                        Ext.Msg.alert(LN('sbi.generic.msg'), LN('sbi.chartengine.configuration.palette.msg.remove'));
	                    }
	                }
	            }]
	        }]
	    }
	    ];
		
		this.add(item);
	},
	
    
    
});