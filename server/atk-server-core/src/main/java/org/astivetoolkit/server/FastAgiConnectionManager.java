/* 
 * Copyright (C) 2010-2014 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
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
package org.astivetoolkit.server;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.astivetoolkit.agi.Connection;
import org.astivetoolkit.agi.fastagi.FastAgiConnection;
import org.astivetoolkit.util.AppLocale;

/**
 * Connection manager for fast agi connections.
 *
 * @since 1.0.0
 * @see ConnectionManager
 */
public class FastAgiConnectionManager implements ConnectionManager {
    // A usual logging class

    private static final Logger LOG = Logger.getLogger(FastAgiConnectionManager.class);
    private ArrayList<Connection> conns;

    /**
     * Creates a new FastAgiConnectionManager object.
     */
    public FastAgiConnectionManager() {
        conns = new ArrayList<Connection>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Connection conn) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageNewConnectionAdded", new String[]{conn.toString()}));
        }

        conns.add(conn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Connection> connections() {
        return conns;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Connection conn) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageRemovingConnection", new String[]{conn.toString()}));
        }

        if (!conn.isClosed()) {
            ((FastAgiConnection) conn).close();
        }

        conns.remove(conn);

        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageDone"));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAll() throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("removingAllConnection"));
        }

        for (Connection conn : conns) {
            if (!conn.isClosed()) {
                ((FastAgiConnection) conn).close();
            }
        }

        conns.clear();

        if (LOG.isDebugEnabled()) {
            LOG.debug(AppLocale.getI18n("messageDone"));
        }
    }
}
