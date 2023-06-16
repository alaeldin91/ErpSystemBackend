package com.alaeldin.erpschoolSystem.security.entity.user;

import com.alaeldin.erpschoolSystem.security.entity.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" ,nullable = false)
    private Integer id;

    @Column(name = "last_Name" ,nullable = false)
    private String lastName;
    @Column(name = "first_Name", nullable = false)
    private String firstName;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "roles",nullable = false)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(
               name = "user_id"
            )},inverseJoinColumns = @JoinColumn(name = "role_id"))

  private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;

       // List<Role> roleList = new ArrayList<>(roles);
        //String roleName = null;
        //for (int i = 0; i < roleList.size(); i++) {
          //  roleName = roleList.get(i).getRoleName();
        //}
        //return List.of(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
