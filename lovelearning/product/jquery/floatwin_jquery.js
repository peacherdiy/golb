(function($) {
	/**
	 * float window on mouse click
	 */
	$.fn.floatwin = function(targetObject) {
		var debug = false;
		
		var off = $(targetObject).offset();
		if(debug){
			alert("off.left "+off.left);
			alert("off.width "+$(targetObject).css('width'));
			alert("off.top "+off.top);
			alert("off.height "+$(targetObject).css('height'));
		}
		
		
		var divLeft = off.left-300;
		var divTop = off.top+15;
		var floatContainer = $(this);
		
		if(debug){
			alert("divTop: "+divTop);
			alert("divLeft: "+divLeft);
		}
		
		floatContainer.css("top",divTop);
		floatContainer.css("left",divLeft);
		floatContainer.show();
		//floatContainer.foucs();
		
		//floatContainer.mouseout(function(){
		  //floatContainer.hide();
			// alert("mouseout");
			
			//return false;
		//});
	};
})(jQuery);