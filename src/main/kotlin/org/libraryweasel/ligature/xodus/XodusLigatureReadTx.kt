/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.libraryweasel.ligature.xodus

import jetbrains.exodus.env.Environment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import org.libraryweasel.ligature.*
import java.lang.RuntimeException

internal class XodusLigatureReadTx(private val environment: Environment): ReadTx {
    private val readTx = environment.beginReadonlyTransaction()

    override fun allStatements(collection: CollectionName): Flow<Statement> {
        TODO("Not yet implemented")
    }

    override fun cancel() {
        readTx.abort()
    }

    override fun collections(): Flow<CollectionName> {
        return if (isOpen()) { environment.getAllStoreNames(readTx).asFlow().map {
            CollectionName(it)
        }} else {
            throw RuntimeException("Transaction is closed.")
        }
    }

    override fun collections(prefix: CollectionName): Flow<CollectionName> {
        TODO("Not yet implemented")
    }

    override fun collections(from: CollectionName, to: CollectionName): Flow<CollectionName> {
        TODO("Not yet implemented")
    }

    override fun isOpen(): Boolean = !readTx.isFinished

    override fun matchStatements(collection: CollectionName, subject: Entity?, predicate: Predicate?, `object`: Object?, context: Entity?): Flow<Statement> {
        TODO("Not yet implemented")
    }

    override fun matchStatements(collection: CollectionName, subject: Entity?, predicate: Predicate?, range: Range<*>, context: Entity?): Flow<Statement> {
        TODO("Not yet implemented")
    }
}
