 #
 # Sonar, entreprise quality control tool.
 # Copyright (C) 2008-2011 SonarSource
 # mailto:contact AT sonarsource DOT com
 #
 # Sonar is free software; you can redistribute it and/or
 # modify it under the terms of the GNU Lesser General Public
 # License as published by the Free Software Foundation; either
 # version 3 of the License, or (at your option) any later version.
 #
 # Sonar is distributed in the hope that it will be useful,
 # but WITHOUT ANY WARRANTY; without even the implied warranty of
 # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 # Lesser General Public License for more details.
 #
 # You should have received a copy of the GNU Lesser General Public
 # License along with Sonar; if not, write to the Free Software
 # Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 #
class UpgradePropertiesToBlobs < ActiveRecord::Migration

  def self.up
    add_column(:properties, :text_value, :text, :null => true)
    Property.reset_column_information
    
    Property.find(:all).each do |p|
      p.text_value=p.prop_value
      p.save!
    end
    
    remove_column(:properties, :prop_value)
    Property.reset_column_information
  end

end