package example

import geb.Page
import geb.error.RequiredPageContentNotPresent

class LoginPage extends Page {
	static url = 'http://127.0.0.1:10081/tadpole'
	static content = {
		title(wait: true) { $("head title")[0] }
		emailAddressInput(wait: true) { $('input[type="text"]:first-of-type') }
		passwordInput(wait: true) { $('input[type="password"]:first-of-type') }
		loginButton(wait: true) { $("div", text:"Login") }
		
	}

	static at = { assert title.contains('Tadpole DB Hub') }

	void login(String loginId, String loginPassword) {
        emailAddressInput.value loginId
		passwordInput.value loginPassword
		loginButton.click()
    }
}

class MainPage extends Page {
	static url = 'http://127.0.0.1:10081/tadpole'
	static content = {
		title(wait: true) { $("head title")[0] }
		conMgrTab(wait: true) { $("div", text:contains("Connection Manager")) }
		newDBConWindow(wait: true) { $("div", text:contains("New Database Connection")) }
	}	
	
	static at = { 
		println 'verification'
		assert title.contains('Tadpole DB Hub') 
		assert conMgrTab.present && newDBConWindow.present
	}

}

