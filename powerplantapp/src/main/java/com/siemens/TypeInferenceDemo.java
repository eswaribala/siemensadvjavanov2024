package com.siemens;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class TypeInferenceDemo {

    public static void main(String[] args){
        var var="var";
        var value=76;
        var height=157.5;

        System.out.println(var.getClass().getName());
        System.out.println(((Object)value).getClass().getSimpleName());
        System.out.println(((Object)height).getClass().getSimpleName());

      List<String> routerNames=StreamDemo.generateRouters().stream().map(r->r.getRouterName()).collect(Collectors.toList());
      routerNames.add(null);
      routerNames.stream()
              .filter(name->name!=null)
              .map((@NotNull var name)->name.toUpperCase())
              .forEach(System.out::println);
    }
}
