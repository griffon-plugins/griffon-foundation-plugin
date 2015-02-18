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
package griffon.builder.javafx.factory

import griffon.javafx.support.foundation.FoundationIcon
import griffon.plugins.foundation.Foundation
import groovyx.javafx.factory.LabeledFactory

/**
 * @author Andres Almiray
 */
public class FoundationIconFactory extends LabeledFactory {
    FoundationIconFactory() {
        super(FoundationIcon)
    }

    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        def iconName = attributes.remove('icon') ?: value
        if (!iconName) {
            throw new IllegalArgumentException("In $name you must define a node value or icon:")
        }

        String iconSize = attributes.remove('size') ?: '16'

        if (iconName instanceof CharSequence) {
            FoundationIcon icon = new FoundationIcon(iconName.toString())
            icon.iconSize = iconSize.toInteger()
            return icon
        } else if (iconName instanceof Foundation) {
            FoundationIcon icon = new FoundationIcon((Foundation) iconName)
            icon.iconSize = iconSize.toInteger()
            return icon
        }

        throw new IllegalArgumentException("$name cannot parse $iconName as a foundation icon description.")
    }
}
