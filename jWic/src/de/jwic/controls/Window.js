//Window
{
		
	doUpdate: function(){		
		return false;
	},
	
	/**
	 * Initialize the window if it does not already exist.
	 */
	afterUpdate: function(element) {
		
		//var win = jQuery('#'+JQryEscape('win_${control.controlID}_div'));	
		var dialogWidth = $control.width;
		dialogWidth += dialogWidth*10/100;
		var dialogHeight= $control.height;
		dialogHeight+= dialogHeight*10/100;
		var win = jQuery('#'+JQryEscape('win_${control.controlID}_div')).dialog({
			autoOpen: false,
			#if($control.title) title: "$escape.escapeJavaScript($control.title)", #else title: '', #end
			#if($control.width != 0) width : dialogWidth, #end
			#if($control.height != 0) height : dialogHeight, #end
			#if($control.top != 0) top : $control.top, #end
			#if($control.left != 0) left : $control.left, #end
			#if(!$control.closable)
				closeOnEscape: false,
				open: function(event, ui) { 
					jQuery(".ui-dialog-titlebar-close",jQuery(this).parent()).hide(); 
					jQuery(".ui-dialog-titlebar-min",jQuery(this).parent()).show();
					jQuery(".ui-dialog-titlebar-max",jQuery(this).parent()).show();
				},
							
			#end
			close: function () {
				JWic.fireAction("$control.controlID", "close", "");	
			},
			
			draggable: #if($control.draggable) true, #else false, #end
			resizable : #if($control.resizable) true, #else false, #end
			modal: #if($control.modal) true, #else false, #end
			cache:false
					
		});
		
		#if($control.isMaximizable())
			var maxBtn = addMaximizeToDialog(win);
			var titlebar = win.parents('.ui-dialog').find('.ui-dialog-titlebar');
			titlebar.dblclick(function(event){
				maximize(win);
			});			
		#end
		#if($control.isMinimizable())
			var minBtn = addMinimizeToDialog(win);	
		#end

		win.parent().appendTo(jQuery("#jwicform"));		
		win.dialog('open');	

		
		function addMinimizeToDialog(dialog){
			if(dialog !== undefined){
				console.log(dialog.parent().css('position'));
				dialog.bind('dialogresize',function(){
					jQuery.data(dialog,'width',dialog.parent().width());
					dialog.parent().css('height', 'auto');
					if(!dialog.is(':visible')){
						jQuery.data(dialog,'isMinimized',false);
						jQuery.data(dialog,'isMaximized',false);
						jQuery.data(dialog,'originalPosition',dialog.parent().offset());
						dialog.parent().css('width',jQuery.data(dialog,'width'));	
						dialog.show();	
						dialog.css('width','auto');
					}
				});
				
				var titlebar = dialog.parents('.ui-dialog').find('.ui-dialog-titlebar');
				//minimize
				var minBtn = jQuery('<a href="#" id="'+dialog.attr('id')+'_minimize" role="button" class="ui-corner-all ui-dialog-titlebar-close ui-dialog-titlebar-min"><span class="ui-icon ui-icon-minusthick">minimize</span></a>')
					.appendTo(titlebar)
					.mouseover(function(){
						jQuery(this).addClass('ui-state-hover');
					})
					.mouseout(function(){
						jQuery(this).removeClass('ui-state-hover');
					})
					.click(function() {
						minimize(dialog);
					});
				return minBtn;
				
			}
		}
		
		function addMaximizeToDialog(dialog){
			if(dialog!==undefined){
				
				dialog.bind('dialogresize',function(){
					jQuery.data(dialog,'width',dialog.parent().width());
					dialog.parent().css('height', 'auto');
					if(!dialog.is(':visible')){
						jQuery.data(dialog,'isMinimized',false);
						jQuery.data(dialog,'isMaximized',false);
						jQuery.data(dialog,'originalPosition',dialog.parent().offset());
						dialog.parent().css('width',jQuery.data(dialog,'width'));	
						dialog.show();	
						dialog.css('width','auto');
					}
				});
				
				
				var titlebar = dialog.parents('.ui-dialog').find('.ui-dialog-titlebar');			
				var maxBtn = jQuery('<a href="#" id="'+dialog.attr('id')+'_maximize" role="button" class="ui-corner-all ui-dialog-titlebar-close ui-dialog-titlebar-max"><span class="ui-icon ui-icon-newwin">maximize</span></a>')
				.appendTo(titlebar)
				.mouseover(function(){
					jQuery(this).addClass('ui-state-hover');
				})
				.mouseout(function(){
					jQuery(this).removeClass('ui-state-hover');
				})
				.click(function(){
					maximize(dialog);
					
				});
				return maxBtn;
				
			}
		}
		
		function maximize(dialog){
			var dialogParent = dialog.parent();
			
			dialogParent.css('overflow','hidden');
			if(jQuery.data(dialog,'isMinimized')){
				jQuery.data(dialog,'isMinimized',false);	
				dialogParent.css('width',jQuery.data(dialog,'width'));	
				dialog.show();
				dialog.css('width','auto');
				
			}
			
			if(!jQuery.data(dialog,'isMaximized')){				
				jQuery.data(dialog,'isMaximized',true);				
				jQuery.data(dialog,'originalPosition',dialogParent.offset());
				jQuery.data(dialog,'width',dialogParent.width());

				
				dialogParent.css('width',jQuery(window).width());
				dialogParent.css('height',jQuery(window).height());
				dialogParent.offset({top:0,left:0});
				dialog.parent().css('position','fixed');
				dialog.css('width','auto');
				
				
			}else{
				jQuery.data(dialog,'isMaximized',false);
				dialog.parent().css('position','absolute');
				dialogParent.offset(jQuery.data(dialog,'originalPosition'));					
				dialogParent.css('width',jQuery.data(dialog,'width'));
				dialogParent.css('height', 'auto');
				
			}
			
			dialog.trigger({type:'maximize',source:dialog})
		};
				
		function minimize(dialog){
			var dialogParent = dialog.parent();					
			dialogParent.css('overflow','hidden');
			if(jQuery.data(dialog,'isMaximized')){
				jQuery.data(dialog,'isMaximized',false);
				dialog.parent().css('position','absolute');
				dialogParent.offset(jQuery.data(dialog,'originalPosition'));
				dialogParent.css('width',jQuery.data(dialog,'width'));	
				dialogParent.css('height', 'auto');
				
			}
			
			if(!jQuery.data(dialog,'isMinimized')){
				
				jQuery.data(dialog,'isMinimized',true);
				jQuery.data(dialog,'width',dialogParent.width());					
				dialog.hide();
				
			}else{
				jQuery.data(dialog,'isMinimized',false);
				dialogParent.css('width',jQuery.data(dialog,'width'));	
				dialog.show();				
			}
		
			dialog.trigger({type:'minimize',source:dialog});
		};
	
		
	
	},
	
	/**
	 * Destroy the window if it still exists.
	 */
	destroy : function(element) {
		var win = jQuery('#'+JQryEscape('win_${control.controlID}_div'));	
		win.dialog('destroy').remove();
		
	}
}