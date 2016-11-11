/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.quickstart.database.models;
import java.io.Serializable;


public class Deal implements Serializable{
    private String restra_name;
    private String content;
    private String val;

    private String id;

    public Deal() {
    }

    public Deal( String restra_name, String content, String val, String id) {
        this.restra_name = restra_name;
        this.content=content;
        this.val=val;
        this.id = id;

    }

    public String getRestra_Name() {
        return restra_name;
    }

    public void setRestra_Name(String name) {
        this.restra_name = name;
    }
    public String getcontent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val =val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
