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

package com.numan1617.tmdb.repository;

import com.numan1617.api.ConfigurationService;
import com.numan1617.api.model.Configuration;
import com.numan1617.api.model.ImageConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;
import rx.subjects.TestSubject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConfigurationRepositoryTest {

    @Mock
    private ConfigurationStorage configurationStorage;
    @Mock
    private ConfigurationService configurationService;
    private TestSubject<TMDBConfiguration> configurationStorageSubject;
    private TestSubject<Configuration> configurationServiceSubject;
    private ConfigurationRepository configurationRepository;
    private TestScheduler testScheduler;

    @Before
    public void setUp() throws Exception {
        testScheduler = new TestScheduler();
        configurationStorageSubject = TestSubject.create(testScheduler);
        configurationServiceSubject = TestSubject.create(testScheduler);

        configurationRepository = new ConfigurationRepository(configurationService, configurationStorage);
    }

    @Test
    public void noDiskConfiguration_networkCalled() {
        TestSubscriber<TMDBConfiguration> testSubscriber = new TestSubscriber<>();

        ImageConfiguration imageConfiguration = new ImageConfiguration(null, "Network", null, null, null, null);
        Configuration configuration = new Configuration(imageConfiguration, null);

        when(configurationStorage.configuration()).thenReturn(configurationStorageSubject);
        when(configurationService.configuration()).thenReturn(configurationServiceSubject);

        configurationRepository.configuration()
                .subscribe(testSubscriber);

        configurationStorageSubject.onCompleted();
        configurationServiceSubject.onNext(configuration);

        testScheduler.triggerActions();

        testSubscriber.assertNoErrors();
        assertEquals(testSubscriber.getOnNextEvents().get(0).getBaseImageUrl(), "Network");
    }

    @Test
    public void diskConfigurationPresent_networkNotCalled() {
        TestSubscriber<TMDBConfiguration> testSubscriber = new TestSubscriber<>();

        ImageConfiguration imageConfiguration = new ImageConfiguration(null, "Storage", null, null, null, null);
        Configuration configuration = new Configuration(imageConfiguration, null);

        when(configurationStorage.configuration()).thenReturn(configurationStorageSubject);
        when(configurationService.configuration()).thenReturn(configurationServiceSubject);

        configurationRepository.configuration()
                .subscribe(testSubscriber);

        configurationStorageSubject.onNext(TMDBConfiguration.from(configuration));
        configurationStorageSubject.onCompleted();

        testScheduler.triggerActions();

        testSubscriber.assertNoErrors();
        assertEquals(testSubscriber.getOnNextEvents().get(0).getBaseImageUrl(), "Storage");
    }

    @Test
    public void diskConfigurationOutdated_networkCalled() {
        TestSubscriber<TMDBConfiguration> testSubscriber = new TestSubscriber<>();

        ImageConfiguration imageConfiguration = new ImageConfiguration(null, "Network", null, null, null, null);
        Configuration configuration = new Configuration(imageConfiguration, null);

        when(configurationStorage.configuration()).thenReturn(configurationStorageSubject);
        when(configurationService.configuration()).thenReturn(configurationServiceSubject);

        configurationRepository.configuration()
                .subscribe(testSubscriber);

        configurationStorageSubject.onNext(TMDBConfiguration.from("Storage", Instant.now().minus(12, ChronoUnit.DAYS)));
        configurationStorageSubject.onCompleted();
        configurationServiceSubject.onNext(configuration);

        testScheduler.triggerActions();

        testSubscriber.assertNoErrors();
        assertEquals("Network", testSubscriber.getOnNextEvents().get(0).getBaseImageUrl());
    }
}