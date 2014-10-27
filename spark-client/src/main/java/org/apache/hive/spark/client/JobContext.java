/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hive.spark.client;

import org.apache.spark.api.java.JavaFutureAction;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.hadoop.hive.common.classification.InterfaceAudience;

/**
 * Holds runtime information about the job execution context.
 *
 * An instance of this class is kept on the node hosting a remote Spark context and is made
 * available to jobs being executed via RemoteSparkContext#submit().
 */
@InterfaceAudience.Private
public interface JobContext {

  /** The shared SparkContext instance. */
  JavaSparkContext sc();

  /**
   * Monitor a job. This allows job-related information (such as metrics) to be communicated
   * back to the client.
   *
   * @return The job (unmodified).
   */
  <T> JavaFutureAction<T> monitor(JavaFutureAction<T> job);

}
