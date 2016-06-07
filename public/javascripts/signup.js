$('.ui.checkbox').checkbox();

$('.ui.form')
  .form({
    fields: {
      firstName: {
        identifier: 'firstName',
        rules: [
          {
            type   : 'empty',
            prompt : 'Please enter your first name'
          }
        ]
      },
      lastName: {
        identifier: 'lastName',
        rules: [
          {
            type   : 'empty',
            prompt : 'Please enter your last name'
          }
        ]
      },
      email: {
        identifier: 'email',
        rules: [
          {
            type   : 'empty',
            prompt : 'Please enter your email'
          }
        ]
      },
      password: {
        identifier: 'password',
        rules: [
          {
            type   : 'empty',
            prompt : 'Please enter a password'
          },
          {
            type   : 'minLength[6]',
            prompt : 'Your password must be at least {ruleValue} characters'
          }
        ]
      },
      usCitizen: {
        identifier: 'usCitizen',
        rules: [
          {
            type   : 'checked',
            prompt : 'Please tick the box to confirm you are a US Citizen'
          }
        ]
      },
      conditions: {
        identifier: 'conditions',
        rules: [
          {
            type   : 'checked',
            prompt : 'You must agree to the terms and conditions, i.e. Homer is a fictional character and as such can\'t stand for President'
          }
        ]
      }
    }
  })
;