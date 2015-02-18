/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.swing.support.foundation

import griffon.plugins.foundation.Foundation
import spock.lang.Specification

/**
 * @author Andres Almiray
 */
class FoundationIconSpec extends Specification {
    def 'Can create a FoundationIcon instance'() {
        given:
        Foundation expected = Foundation.FI_ADDRESS_BOOK

        expect:
        FoundationIcon faIcon = new FoundationIcon(expected)
        faIcon.foundation == expected
    }

    def 'Invalid FoundationIcon arguments'() {
        when:
        new FoundationIcon(arg)

        then:
        thrown(IllegalArgumentException)

        where:
        arg   | _
        ''    | _
        ' '   | _
        'foo' | _
    }
}
