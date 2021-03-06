/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jdye64.nifi.shell.service;

import java.io.IOException;

import org.apache.nifi.web.api.entity.ControllerStatusEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jdye64.nifi.shell.client.NiFiAPIClient;
import com.github.jdye64.nifi.shell.configuration.Environment;

/**
 * Created by jdyer on 4/8/16.
 */
public class ControllerServiceImplementation
    implements ControllerService {

    private NiFiAPIClient client;
    private ObjectMapper mapper;

    public ControllerServiceImplementation(Environment environment) {
        client = new NiFiAPIClient(environment.getHostname(), environment.getPort());
        mapper = new ObjectMapper();
    }

    public String getController(String clientId) {
        return this.client.get("/controller");
    }

    public String getControllerAbout(String clientId) {
        return this.client.get("/controller/about");
    }

    public String postControllerArchieve(String version, String clientId) {
        return null;
    }

    public String getControllerAuthorties(String clientId) {
        return this.client.get("/controller/about");
    }

    public String getControllerBanners(String clientId) {
        return this.client.get("/controller/banners");
    }

    public String getControllerBulletinBoard(String clientId, String after, String sourceName, String message, String sourceId, String groupId, String limit) {
        return null;
    }

    public String getControllerConfiguration(String clientId) {
        return this.client.get("/controller/config");
    }

    public String putControllerConfiguration(String clientId) {
        return null;
    }

    public ControllerStatusEntity getControllerStatus(String clientId) {
        String jsonResponse = this.client.get("/controller/status");
        try {
            return mapper.readValue(jsonResponse, ControllerStatusEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String postControllerTemplate(String clientId, String name, String description, String snippetId) {
        return null;
    }

    public String getControllerAllTemplates(String clientId) {
        return this.client.get("/controller/templates");
    }

    public String getControllerTemplate(String clientId, String templateId) {
        return null;
    }

    public String deleteControllertemplate(String clientId, String templateId) {
        return null;
    }

    public String getControllerSystemDiagnostics(String clientId) {
        return this.client.get("/controller/diagnostics");
    }
}
