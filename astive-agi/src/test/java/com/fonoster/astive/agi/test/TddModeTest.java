/* 
 * Copyright (C) 2017 by Fonoster Inc (http://fonoster.com)
 * http://github.com/fonoster/astive
 *
 * This file is part of Astive
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fonoster.astive.agi.test;

import junit.framework.TestCase;
import com.fonoster.astive.agi.AgiException;
import com.fonoster.astive.agi.CommandProcessor;
import com.fonoster.astive.agi.command.TddMode;

/**
 * Test case for command {@link com.fonoster.astive.agi.command.TddMode}.
 * 
 * @since 1.0
 */
public class TddModeTest extends TestCase {
  /**
   * Creates a new TddModeTest object.
   *
   * @param testName {@inheritDoc}.
   */
  public TddModeTest(String testName) {
    super(testName);
  }

  /**
   * Test method.
   *
   * @throws AgiException if command is malformed.
   */
  public void testCommand() throws AgiException {
    Boolean enable = true;
    String on = "ON";
    StringBuilder b = new StringBuilder("TDD MODE");
    b.append(" ");
    b.append("\"");
    b.append(on);
    b.append("\"");

    TddMode command = new TddMode(enable);
    assertEquals(b.toString(), CommandProcessor.buildCommand(command));
  }
}
