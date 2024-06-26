Metrics Logs
============

Metrics are also logged to `$site_path/logs/upload_pack_metrics_log`.

Time Format
-----------

For all timestamps, the format [dd MMM yyyy HH:mm:ss,SSS] is used. This format is both ISO 8601 and
RFC3339 compatible, ensuring clarity and consistency across different systems and regions.

Field Order
-----------

The metrics are organized in a specific sequence to facilitate easy parsing and analysis. The order
of fields is as follows:

- repoName - The name of the repository for which the metric is being registered. This helps in
  identifying the source of the metric and correlating it with other related metrics for comprehensive
  analysis.
- timeSearchingForReuse - This field records the time, in milliseconds, spent in the process of
  matching existing data representations against the objects that will be transmitted. It's a critical
  metric for understanding the efficiency of data retrieval and transmission processes.
- bitmapIndexMisses - This metric counts the number of objects that had to be located through an
  object walk because they were not found in the bitmap indices. It's an essential measure for assessing
  the effectiveness of bitmap indices in speeding up object retrieval operations.
- totalTime - This metric records the total time (in milliseconds) that is spend on fetch/clone
  end-to-end including transfer time.
- totalBytes - This metric records the total number of bytes written. This size includes the pack
  header, trailer, thin pack, and reused cached pack(s).
- timeWriting - time jgit needed to write packfile, from start of header until end of trailer.
  The transfer speed can be approximated by dividing total bytes by this value.
