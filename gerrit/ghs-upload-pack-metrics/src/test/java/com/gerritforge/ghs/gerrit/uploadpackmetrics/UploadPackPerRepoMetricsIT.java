// Copyright (C) 2024 GerritForge, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.gerritforge.ghs.gerrit.uploadpackmetrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.gerrit.acceptance.LightweightPluginDaemonTest;
import com.google.gerrit.acceptance.TestPlugin;
import com.google.gerrit.server.config.SitePaths;
import com.google.inject.Inject;
import org.junit.Test;

@TestPlugin(
    name = "ghs-upload-pack-metrics",
    sysModule = "com.gerritforge.ghs.gerrit.uploadpackmetrics.Module")
public class UploadPackPerRepoMetricsIT extends LightweightPluginDaemonTest {
  @Inject private SitePaths sitePaths;

  @Test
  public void shouldCreateLogFileWithMetrics() {
    assertThat(
            sitePaths
                .logs_dir
                .resolve(UploadPackMetricsLogger.UPLOAD_PACK_METRICS_LOG_NAME)
                .toFile()
                .exists())
        .isTrue();
  }
}
