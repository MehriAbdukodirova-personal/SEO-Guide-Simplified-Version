package com.learning.android.seoguidesimplifiedversion.entity;

import java.util.ArrayList;

public class Steps {

    public static ArrayList<Step> getSteps(){
        ArrayList<Step> steps= new ArrayList<Step>();

        Step step1 = new Step(1);
        step1.setTip("Site Verification");
        step1.setDescription("Prove ownership to Google");
        step1.setWhy("Gain access to Google search data");
        step1.setHow("Tool to use:\n" +
                "Google Search Console");
        step1.setVideoId("lrj7LwcZEyA");

        Step step2 = new Step(2);
        step2.setTip("Sitemap Creation & Submission");
        step2.setDescription("Help Google understand website's structure");
        step2.setWhy("Get website pages indexed by Google");
        step2.setHow("Tools to use:\n" +
                "Free sitemap generator or SEO plugin (Wordpress)\n" +
                "Google Search Console");
        step2.setVideoId("GsbKTAOSVfw");

        Step step3 = new Step(3);
        step3.setTip("Robots.txt File Creation");
        step3.setDescription("Guide Google's bots");
        step3.setWhy("Tell Google what's important");
        step3.setHow("Tools to use:\n" +
                "Notepad or Any text editor");
        step3.setVideoId("exLtHn9ZKNk");

        Step step4 = new Step(4);
        step4.setTip("Site Submission & Indexing");
        step4.setDescription("Prompt Google to crawl and re-index your website");
        step4.setWhy("Update Google's index with latest website content");
        step4.setHow("Tools to use:\n" +
                "Google Search Console");
        step4.setVideoId("NWKbhP9b4QE");

        Step step5 = new Step(5);
        step5.setTip("Keyword Identification");
        step5.setDescription("Set your SEO campaign goals");
        step5.setWhy("Pick keywords for best results (more lucrative & less competitive)");
        step5.setHow("Tools to use:\n" +
                "Google auto-suggest\n" +
                "Google Search Console");
        step5.setVideoId("9nIA-6Ga_xk");

        Step step6 = new Step(6);
        step6.setTip("On-Page Optimisation - Back-End Code");
        step6.setDescription("Help Google read information from your website");
        step6.setWhy("Include keywords in page titles and descriptions");
        step6.setHow("Tools to use:\n" +
                "Free website audit tool\n" +
                "Any website editor or SEO plugin (Wordpress)");
        step6.setVideoId("Vp-5QKz0Kro");

        Step step7 = new Step(7);
        step7.setTip("On-Page Optimisation - Content");
        step7.setDescription("Create website content with your chosen keywords");
        step7.setWhy("Ensure your content is relevant and unique");
        step7.setHow("Tools to use:\n" +
                "Any website editor");
        step7.setVideoId("XmkBaOrvOPk");

        Step step8 = new Step(8);
        step8.setTip("On-Page Optimisation - Eliminate Broken Links");
        step8.setDescription("Broken links result in loss of traffic and reputation");
        step8.setWhy("Restore missing pages or set 301 Redirects");
        step8.setHow("Tools to use:\n" +
                "Google Search Console");
        step8.setVideoId("-rF0B3NFcwg");

        Step step9 = new Step(9);
        step9.setTip("Off-Page Optimisation - Backlink Profile");
        step9.setDescription("Help Google gauge website's popularity and authenticity");
        step9.setWhy("Build high-quality backlinks and remove low-quality backlinks");
        step9.setHow("Tools to use:\n" +
                "Google Search Console\n" +
                "Google Disavow Tool");
        step9.setVideoId("ZFcwCOnFS34");

        Step step10 = new Step(10);
        step10.setTip("Results and Strategy Review");
        step10.setDescription("Reviewing campaign progress and revise SEO strategy");
        step10.setWhy("Repeat SEO steps");
        step10.setHow("Tools to use:\n" +
                "Google Search Console");
        step10.setVideoId("68VMShxhZqU");

        steps.add(step1);
        steps.add(step2);
        steps.add(step3);
        steps.add(step4);
        steps.add(step5);
        steps.add(step6);
        steps.add(step7);
        steps.add(step8);
        steps.add(step9);
        steps.add(step10);

        return steps;
    }
}
