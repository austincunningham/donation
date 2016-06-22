/** force semantic ui forms to work*/ 
$('.ui.dropdown').dropdown();
//$('#progress').progress();

//$('.ui.form')
//.form({
//  amountDonated: {
//    identifier: 'amountDonated',
//    rules: [
//      {
//        type: 'empty',
//        prompt: 'You forgot to give us money , Please select amount to donate'
//      }
//    ]
//  }
//},
//{
//	onSuccess : function() {
//		inline: true,
//	    console.log('on success');
//	    submitForm();
//	    return false; // dropdown remains open following press donate button. progress bar fails on return true. why?
//	} 
//});

/**
 * Semantic ui form validation version 2
 */

$('.ui.form').form({
	fields: {	
	amountDonated: {
	  identifier: 'amountDonated',
	  rules: [{
	      type: 'empty',
	      prompt: 'You forgot to give us money , Please select amount to donate'
	    },],
	},
},

	onSuccess : function() {
		inline: true,
	    console.log('on success');
	    submitForm();
	    return false; // dropdown remains open following press donate button. progress bar fails on return true. why?
	} 
});


//function submitForm() {
//	  const formData = $('.ui.form.segment input').serialize(); 
//	  $.ajax({
//	    type: 'POST',
//	    url: '/donation/donate',
//	    data: formData,
//		success: function(response) {            
//			console.log("make donation page submitForm response: " + response.progress);
//			$('.ui.indicating.progress').progress({
//				  percent: response.progress
//				});
//			$('#progresslabel').text(response.progress + " % of target achieved to date for Homer Simpson ");
//		}
//	  });
//	}
//$('.ui.dropdown').dropdown();

//$('.ui.submit.button').click(function () {
function submitForm() {
  const formData = $('.ui.form.segment input').serialize();
  $.ajax({
    type: 'POST',
    url: '/Donation/donate',
    data: formData,
    limitValues: false,
    success: function (response) {
    	if (response.progress > 100){
		  $('.ui.indicating.progress').progress({
		    	percent: 100
	      });
		  $('#progresslabel').text(response.progress + " % you have exceeded the target for  Homer Simpson");
       	}else{
	      console.log('make donation page submitForm response: ' + response.progress);
	      $('.ui.indicating.progress').progress({
			  percent: response.progress
			});
		  $('#progresslabel').text(response.progress + " % of target achieved to date for candidate Homer Simpson");
    	}
    }
  });
}
