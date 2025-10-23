package org.project.commonUse.PlayItRight;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({"system:properties", "classpath:config.properties", "classpath:allure.properties"})
public interface ConfigAllure extends org.aeonbits.owner.Config {

    @Key("allure.results.directory")
    String allureResultsDir();

    @Key("base.url")
    String baseUrl();

    @Key("base.test.video.path")
    String baseTestVideoPath();

    @Key("defaultTimeout")
    int defaultTimeout();

    @Key("poolingInterval")
    int poolingInterval();

    @Key("browserToStartTimeout")
    int browserToStartTimeout();

    @Key("tracesPath")
    String tracesPath();

    @Key("headless")
    boolean headless();

    @Key("devTools")
    boolean devTools();

    @Key("saveTraces")
    boolean saveTraces();

    @Key("slow.motion")
    int slowMotion();

    @Key("video")
    boolean video();

    @Key("browser")
    @DefaultValue("CHROMIUM")
    String browser();
}
