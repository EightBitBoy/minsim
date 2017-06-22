# More documentation about how to customize your build
# can be found here:
# https://docs.fastlane.tools
fastlane_version "1.109.0"

# This value helps us track success metrics for Fastfiles
# we automatically generate. Feel free to remove this line
# once you get things running smoothly!
generated_fastfile_id "2485d2ce-1eff-49c5-83ea-3d0658ba5f49"

default_platform :android

# Fastfile actions accept additional configuration, but
# don't worry, fastlane will prompt you for required
# info which you can add here later
lane :beta do
  # build the release variant
  gradle(task: "assembleRelease")

  # upload to Google Play
  supply(track: "beta")

  # slack(
  #   slack_url: "https://hooks.slack.com/services/IDS"
  # )
end
