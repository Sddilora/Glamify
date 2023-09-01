import { Component } from '@angular/core';
import { NAVBAR_MENUS, NavbarMenu } from 'src/app/interface/navbar-menus';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  mainMenus = NAVBAR_MENUS;

  mainmenus() : Array<string> {
    return Object.values(this.mainMenus.map(menu => menu.name));
  }

  // submenus(menuName: string) : Array<string> {
  //   return this.mainMenus.find(menu => menu.name === menuName).submenus.map(submenu => submenu.name);
  // } // Object is possibly 'undefined'.ts(2532)
  // // Object is possibly 'undefined

  // return Array<string> or undefined
  submenus(menuName: string) : Array<string> | undefined {
    // due to above error, we need to check if the menuName is undefined
    if (this.mainMenus.find(menu => menu.name === menuName)?.submenus) {
      return this.mainMenus.find(menu => menu.name === menuName)?.submenus?.map(submenu => submenu.name);
    } else {
      return [];
    }
  }
}
