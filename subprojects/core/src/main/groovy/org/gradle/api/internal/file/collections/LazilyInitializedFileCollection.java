/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.file.collections;

import org.gradle.api.file.FileCollection;
import org.gradle.api.internal.file.CompositeFileCollection;

/**
 * A {@link FileCollection} whose contents is created lazily.
 */
public abstract class LazilyInitializedFileCollection extends CompositeFileCollection {
    private FileCollection delegate;

    @Override
    public void resolve(FileCollectionResolveContext context) {
        if (delegate == null) {
            delegate = createDelegate();
        }
        context.add(delegate);
    }

    public abstract FileCollection createDelegate();
}
