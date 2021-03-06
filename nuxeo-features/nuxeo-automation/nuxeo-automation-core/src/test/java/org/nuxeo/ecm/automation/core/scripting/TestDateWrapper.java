/*
 * (C) Copyright 2013 Nuxeo SA (http://nuxeo.com/) and others.
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
 *
 * Contributors:
 *     Thierry Martins
 */
package org.nuxeo.ecm.automation.core.scripting;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class TestDateWrapper {

    DateWrapper currentDate;

    private DateTime datetime;

    @Before
    public void init() {
        Calendar calendar = Calendar.getInstance();
        datetime = new DateTime();
        calendar.setTime(datetime.toDate());
        currentDate = new DateWrapper(calendar);
    }

    @Test
    public void testIncrementSeconds() {
        DateWrapper wrapper = currentDate.seconds(25);
        assertEquals(datetime.plusSeconds(25).getMillis(), wrapper.getCalendar().getTimeInMillis());
        wrapper = currentDate.seconds(-10);
        assertEquals(datetime.minusSeconds(10).getMillis(), wrapper.getCalendar().getTimeInMillis());
    }

    @Test
    public void testIncrementDay() {
        DateWrapper wrapper = currentDate.days(-10);
        assertEquals(datetime.minusDays(10).getMillis(), wrapper.getCalendar().getTimeInMillis());
        wrapper = currentDate.days(20);
        assertEquals(datetime.plusDays(20).getMillis(), wrapper.getCalendar().getTimeInMillis());
    }

    @Test
    public void testIncrementMonth() {
        DateWrapper wrapper = currentDate.months(5);
        assertEquals(datetime.plusMonths(5).getMillis(), wrapper.getCalendar().getTimeInMillis());
        wrapper = currentDate.months(-2);
        assertEquals(datetime.minusMonths(2).getMillis(), wrapper.getCalendar().getTimeInMillis());
    }

    @Test
    public void testIncrementYear() {
        DateWrapper wrapper = currentDate.years(-1);
        assertEquals(datetime.minusYears(1).getMillis(), wrapper.getCalendar().getTimeInMillis());
        wrapper = currentDate.years(32);
        assertEquals(datetime.plusYears(32).getMillis(), wrapper.getCalendar().getTimeInMillis());
    }

}