/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2011 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.wsclient.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sonar.wsclient.JdkUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TimeMachineQueryTest {

  private TimeZone systemTimeZone;

  @Before
  public void before() {
    systemTimeZone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    WSUtils.setInstance(new JdkUtils());
  }

  @After
  public void after() {
    TimeZone.setDefault(systemTimeZone);
  }

  @Test
  public void shouldGetUrl() {
    TimeMachineQuery query = TimeMachineQuery.createForMetrics("12345", "ncloc", "coverage");
    assertThat(query.getUrl(), is("/api/timemachine?resource=12345&metrics=ncloc,coverage&"));
  }

  @Test
  public void shouldSetPeriod() throws ParseException {
    Date from = new SimpleDateFormat("yyyy-MM-dd").parse("2010-02-18");
    Date to = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2010-03-25 14:59");
    TimeMachineQuery query = TimeMachineQuery.createForMetrics("12345", "ncloc").setFrom(from).setTo(to);
    assertThat(query.getUrl(), is("/api/timemachine?resource=12345&metrics=ncloc&fromDateTime=2010-02-18T00%3A00%3A00%2B0000&toDateTime=2010-03-25T14%3A59%3A00%2B0000&"));
  }
}
