check = function(source, result) { 
	new Ajax.Request('MyPhoneBook.checker/' + $F(source), { 
		method : 'get', 
		onSuccess : function(transport) { 
			$(result).update(transport.responseText); 
		} 
	}); 
};