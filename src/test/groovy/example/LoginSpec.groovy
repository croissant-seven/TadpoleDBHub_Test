package example

import geb.Browser
import spock.lang.Specification

class LoginSpec extends Specification {
	def '로그인 테스트 - Manager 계정으로 로그인한다.'() {		
		Browser.drive {
			given:
			to LoginPage
			at LoginPage
			
			when:
			login('manager.tadpole@gmail.com', 'manager')
			
			then:
			at MainPage
		}
		expect: true
	}
}



