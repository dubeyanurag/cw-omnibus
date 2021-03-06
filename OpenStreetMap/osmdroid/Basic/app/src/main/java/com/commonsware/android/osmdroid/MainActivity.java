/***
  Copyright (c) 2016 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Android Development_
    https://commonsware.com/Android
 */

package com.commonsware.android.osmdroid;

import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends RequiredPermissionsActivity {
  private static String[] PERMS={
    WRITE_EXTERNAL_STORAGE
  };

  @Override
  protected String[] getRequiredPermissions() {
    return(PERMS);
  }

  @Override
  protected void createForRealz() {
    setContentView(R.layout.activity_main);

    OpenStreetMapTileProviderConstants
      .setUserAgentValue(getPackageName());

    MapView map=(MapView)findViewById(R.id.map);

    map.setTileSource(TileSourceFactory.MAPNIK);
    map.setMultiTouchControls(true);
    map.getController().setZoom(18);
    map
      .getController()
      .setCenter(new GeoPoint(40.76793169992044, -73.98180484771729));
  }
}
