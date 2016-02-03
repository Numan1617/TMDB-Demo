/*
 * Copyright 2016 James Newman (Numan1617)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.numan1617.tmdb.feature.splash;

import com.numan1617.tmdb.repository.ConfigurationRepository;
import com.numan1617.tmdb.repository.TMDBConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.subjects.BehaviorSubject;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    private final BehaviorSubject<TMDBConfiguration> configurationServiceSubject = BehaviorSubject.create();

    @Mock
    private SplashPresenter.View view;
    @Mock
    private ConfigurationRepository configurationRepository;

    private SplashPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new SplashPresenter(view, configurationRepository);
        when(configurationRepository.configuration()).thenReturn(configurationServiceSubject);
    }

    @Test
    public void initialise() {
        presenter.initialise();
        verify(configurationRepository).configuration();
    }
}