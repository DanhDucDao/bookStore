
$('#addToCartForm button').on('click', function(e) {
	sendAddToCartFormToServer(e);
})

function sendAddToCartFormToServer(e) {
	e.preventDefault();
	var details = $('#addToCartForm').serialize();
	$.ajax({
		type: "POST",
		url: 'http://localhost:8080/BookStore/addToCart',
		timeout: 2000,
		data: details,
		
		complete: function() {
			console.log('complete');
		},
		
		error: function(data) {
			console.log("error")
		},

		success: function(data) {
			var cart = JSON.parse(data);
			console.log(cart);
		}
	})
}

function displayCartPopup(cart) {

}

