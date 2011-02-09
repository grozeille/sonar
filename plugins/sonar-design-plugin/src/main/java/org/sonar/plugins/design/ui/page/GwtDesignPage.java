/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2009 SonarSource SA
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
package org.sonar.plugins.design.ui.page;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.Java;
import org.sonar.api.resources.Resource;
import org.sonar.api.web.*;
import org.sonar.plugins.design.ui.page.client.DesignPage;

@ResourceQualifier({Resource.QUALIFIER_PROJECT, Resource.QUALIFIER_MODULE, Resource.QUALIFIER_PACKAGE, Resource.QUALIFIER_DIRECTORY})
@DefaultTab(metrics={CoreMetrics.DEPENDENCY_MATRIX_KEY, CoreMetrics.PACKAGE_FEEDBACK_EDGES_KEY, CoreMetrics.PACKAGE_CYCLES_KEY, CoreMetrics.PACKAGE_TANGLE_INDEX_KEY, CoreMetrics.PACKAGE_TANGLES_KEY, CoreMetrics.FILE_CYCLES_KEY, CoreMetrics.FILE_TANGLE_INDEX_KEY, CoreMetrics.FILE_TANGLES_KEY, CoreMetrics.FILE_FEEDBACK_EDGES_KEY})
@NavigationSection({NavigationSection.RESOURCE, NavigationSection.RESOURCE_TAB})
@UserRole(UserRole.USER)
public class GwtDesignPage extends GwtPage {

  public String getGwtId() {
    return DesignPage.GWT_ID;
  }

  public String getTitle() {
    return "Design";
  }

}