/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.test.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.UDFContext;

public class UDFContextTestEvalFunc extends EvalFunc<Integer> {
    public UDFContextTestEvalFunc() {
        Properties p = UDFContext.getUDFContext().getUDFProperties(this.getClass());
        p.setProperty("key1", "5");
    }

    @Override
    public Integer exec(Tuple input) throws IOException {
        String s = (UDFContext.getUDFContext().getUDFProperties(this.getClass()).getProperty("key1"));
	    return Integer.valueOf(s);
    }

}
