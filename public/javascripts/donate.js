/** force semantic ui forms to work*/ 
$('.ui.dropdown').dropdown();
$('#progress').progress();

$('.ui.form')
.form({
  amountDonated: {
    identifier: 'amountDonated',
    rules: [
      {
        type: 'empty',
        prompt: 'You forgot to give us money , Please select amount to donate'
      }
    ]
  }
})
;
