package edu.wpi.first.desktop.plugin;

/**
 * Describes a plugin required by another.
 */
public final class Requirement {

  private final String groupId;
  private final String name;
  private final String minVersion;

  /**
   * Creates a new requirement.
   *
   * @param groupId    the group ID of the required plugin
   * @param name       the name of the required plugin
   * @param minVersion the minimum required version of the plugin. If a plugin with the same group ID and name is
   *                   present, it will be considered to meet the requirement iff its version is at <i>least</i> this
   *                   version and its <i>major version</i> is equal to the specified major version; for example,
   *                   requiring at least version "1.2.3" will be met with version "1.3.0" but not "2.0.0".
   */
  public Requirement(String groupId, String name, String minVersion) {
    this.groupId = groupId;
    this.name = name;
    this.minVersion = minVersion;
  }

  public static Requirement fromAnnotation(Requires annotation) {
    return new Requirement(annotation.groupId(), annotation.name(), annotation.minVersion());
  }

  public String getGroupId() {
    return groupId;
  }

  public String getName() {
    return name;
  }

  public String getMinVersion() {
    return minVersion;
  }
}